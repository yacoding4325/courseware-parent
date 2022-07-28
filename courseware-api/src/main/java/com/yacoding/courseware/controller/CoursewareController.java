package com.yacoding.courseware.controller;

import com.yacoding.courseware.service.CoursewareService;
import com.yacoding.courseware.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yaCoding
 * @create 2022-07-27 下午 1:50
 */

@RestController
@RequestMapping("courseware")
public class CoursewareController {

    @Autowired
    private CoursewareService coursewareService;

    @GetMapping("/list")
    public Result listCourseWare(@RequestParam Integer start) {
        return coursewareService.list(start);
    }

    @GetMapping("/getCarousel")
    public Result getCarousel() {
        return coursewareService.getCarousel();
    }
}
