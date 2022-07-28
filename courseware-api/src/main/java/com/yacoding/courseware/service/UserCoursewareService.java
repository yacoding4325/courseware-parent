package com.yacoding.courseware.service;

/**
 * @Author yaCoding
 * @create 2022-07-28 下午 5:52
 */


import com.yacoding.courseware.common.Result;
import com.yacoding.courseware.config.AliyunConfig;
import com.yacoding.courseware.handler.UserThreadLocal;
import com.yacoding.courseware.mapper.UserCoursewareMapper;
import com.yacoding.courseware.pojo.dto.UserCoursewareDto;
import com.yacoding.courseware.pojo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserCoursewareService {

    @Resource
    private UserCoursewareMapper userCoursewareMapper;


    public Result getMyCourseware() {
        UserDto userDto = UserThreadLocal.get();
        Long id = userDto.getId();
        List<UserCoursewareDto> myCourseware = userCoursewareMapper.findMyCourseware(id);
//        myCourseware = myCourseware.stream().peek(userCoursewareDto -> userCoursewareDto.getCourseware().setUrl(aliyunConfig.getUrl() + userCoursewareDto.getCourseware().getUrl())).collect(Collectors.toList());
        return Result.SUCCESS(myCourseware);
    }
}