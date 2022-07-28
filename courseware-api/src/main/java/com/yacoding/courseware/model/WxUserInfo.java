package com.yacoding.courseware.model;

/**
 * @Author yaCoding
 * @create 2022-07-27 下午 2:27
 */

import lombok.Data;

@Data
public class WxUserInfo {

    private String openId;

    private String nickName;

    private String gender;

    private String city;

    private String province;

    private String country;

    private String avatarUrl;

    private String unionId;
}