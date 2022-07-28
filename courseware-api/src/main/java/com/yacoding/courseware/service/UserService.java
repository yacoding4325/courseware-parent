package com.yacoding.courseware.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yacoding.courseware.handler.UserThreadLocal;
import com.yacoding.courseware.utils.JWTUtils;
import com.yacoding.courseware.common.RedisKey;
import com.yacoding.courseware.mapper.UserMapStruct;
import com.yacoding.courseware.mapper.UserMapper;
import com.yacoding.courseware.model.WXAuth;
import com.yacoding.courseware.model.WxUserInfo;
import com.yacoding.courseware.pojo.User;
import com.yacoding.courseware.pojo.dto.UserDto;
import com.yacoding.courseware.common.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author yaCoding
 * @create 2022-07-28 下午 5:31
 */
@SuppressWarnings({"all"})
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;
    @Autowired
    private WxService wxService;
    @Autowired
    private UserMapStruct userMapStruct;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Value("${wxmini.secret}")
    private String secret;
    @Value("${wxmini.appid}")
    private String appid;



    public UserDto login(UserDto userDto) {
        // 登录成功 封装用户信息到token
        userDto.setPassword(null);
        userDto.setUsername(null);
        userDto.setOpenId(null);
        userDto.setWxUnionId(null);
        String token = JWTUtils.sign(userDto.getId());
        userDto.setToken(token);
        //保存到redis内,下次就直接跳过验证
        redisTemplate.opsForValue().set(RedisKey.TOKEN_KEY + token, JSON.toJSONString(userDto), 7, TimeUnit.DAYS);
        return userDto;
    }

    public Result register(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        User queryUser = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getOpenId, user.getOpenId()));
        if (queryUser == null) {
            userMapper.insert(user);
        }
        //已存在直接登录
        return Result.SUCCESS(login(userDto));
    }

    public Result authLogin(WXAuth wxAuth) {
        try {
            String wxRes = wxService.wxDecrypt(wxAuth.getEncryptedData(), wxAuth.getSessionId(), wxAuth.getIv());
            WxUserInfo wxUserInfo = JSON.parseObject(wxRes,WxUserInfo.class);

            User user = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getOpenId, wxUserInfo.getOpenId()));
            if (user != null) {
                //登录成功
                UserDto userDto = new UserDto();
                BeanUtils.copyProperties(user,userDto);
                return Result.SUCCESS(this.login(userDto));
            } else {
                UserDto userDto = new UserDto();
                userDto.from(wxUserInfo);
                return this.register(userDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.FAIL();
    }

    public Result userinfo(String token, Boolean refresh) {
        /**
         * 1. 根据token 来验证此token 是否有效
         * 2. refresh 如果为true 代表刷新 重新生成token和redis里面重新存储 续期
         * 3. false直接返回用户信息 -》 redis中 查询出来 直接返回
         */
        token = token.replace("Bearer ","");
        boolean verify = JWTUtils.verify(token);
        if (!verify){
            return Result.FAIL("未登录");
        }
        String userJson = redisTemplate.opsForValue().get(RedisKey.TOKEN + token);
        if (StringUtils.isBlank(userJson)){
            return Result.FAIL("未登录");
        }
        UserDto userDto = JSON.parseObject(userJson, UserDto.class);
        if (refresh){
            token = JWTUtils.sign(userDto.getId());
            userDto.setToken(token);
            redisTemplate.opsForValue().set(RedisKey.TOKEN+token,JSON.toJSONString(userDto),7,TimeUnit.DAYS);
        }
        return Result.SUCCESS(userDto);
    }


    public Result userinfo(Boolean refresh) {
        UserDto userDto = UserThreadLocal.get();
        if (refresh){
            //刷新token
            String token = null;
            redisTemplate.opsForValue().set(RedisKey.TOKEN + token ,JSON.toJSONString(userDto),7,TimeUnit.DAYS);
        }
        return Result.SUCCESS(userDto);
    }
}