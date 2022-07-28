package com.yacoding.courseware.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yacoding.courseware.pojo.Courseware;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserCoursewareDto {
    private Integer id;

    private Integer userId;
    private Courseware courseware;
    private Integer cwId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
}
