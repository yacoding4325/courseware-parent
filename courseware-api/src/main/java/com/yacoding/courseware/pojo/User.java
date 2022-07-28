package com.yacoding.courseware.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author yaCoding
 * @create 2022-07-28 下午 5:34
 */

@Data
@TableName("user")
public class User implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String nickname;

    private String username;

    private String password;

    private String gender;

    /**
     * 头像
     */
    private String portrait;

    /**
     * 背景图片
     */
    private String background;


    private String phoneNumber;

    private String openId;

    private String wxUnionId;


}
