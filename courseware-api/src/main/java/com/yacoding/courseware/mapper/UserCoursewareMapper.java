package com.yacoding.courseware.mapper;

import com.yacoding.courseware.pojo.dto.UserCoursewareDto;

import java.util.List;

/**
 * @Author yaCoding
 * @create 2022-07-28 下午 5:53
 */

public interface UserCoursewareMapper {
    List<UserCoursewareDto> findMyCourseware(Long id);
}
