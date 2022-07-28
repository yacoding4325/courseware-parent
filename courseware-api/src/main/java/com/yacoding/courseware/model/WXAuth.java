package com.yacoding.courseware.model;

/**
 * @Author yaCoding
 * @create 2022-07-27 下午 2:23
 */

import lombok.Data;

@Data
public class WXAuth {
    private String encryptedData;
    private String iv;
    private String sessionId;
}