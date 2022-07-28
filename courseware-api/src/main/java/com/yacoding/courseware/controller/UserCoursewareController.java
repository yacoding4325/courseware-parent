package com.yacoding.courseware.controller;

import com.yacoding.courseware.common.Result;
import com.yacoding.courseware.service.UserCoursewareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("userCourseware")
public class UserCoursewareController {

    @Autowired
    private UserCoursewareService userCoursewareService;

    @GetMapping("/myCourseware")
    public Result getMyCourseware() {
        return userCoursewareService.getMyCourseware();
    }
}