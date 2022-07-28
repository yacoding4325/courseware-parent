package com.yacoding.courseware.controller;

import com.alibaba.fastjson.JSON;
import com.yacoding.courseware.common.RedisKey;
import com.yacoding.courseware.common.Result;
import com.yacoding.courseware.handler.UserThreadLocal;
import com.yacoding.courseware.model.WXAuth;
import com.yacoding.courseware.pojo.dto.UserDto;
import com.yacoding.courseware.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Author yaCoding
 * @create 2022-07-28 下午 5:30
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/getSessionId")
    public Result getSessionId(@RequestParam String code) {
        String sessionId = userService.getSessionId(code);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("sessionId", sessionId);
        return Result.SUCCESS(hashMap);
    }



}

