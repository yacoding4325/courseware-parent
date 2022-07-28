package com.yacoding.courseware.pojo.dto;

import com.yacoding.courseware.model.WxUserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @Author yaCoding
 * @create 2022-07-27 下午 2:27
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    private Long id;
    private String nickname;
    //更新的时候可以为null(代表不更新)
    private String username;
    @NotNull
    private String password;
    private String gender;
    @NotNull
    private String phoneNumber;
    /**
     * 背景图片
     */
    private String background;
    private String portrait;

    private String openId;

    private String wxUnionId;

    //dto拓展属性
    private String token;
    List<String> permissions;
    List<String> roles;
    //验证码
    private String code;

    public void from(WxUserInfo wxUserInfo) {
        this.nickname = wxUserInfo.getNickName();
        this.portrait = wxUserInfo.getAvatarUrl();
        this.username = "";
        this.password = "";
        this.phoneNumber = "";
        this.gender = wxUserInfo.getGender();
        this.openId = wxUserInfo.getOpenId();
        this.wxUnionId = wxUserInfo.getUnionId();
    }
}

