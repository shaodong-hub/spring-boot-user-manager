package com.github.user.manager.security.pojo.dto;

import com.github.user.manager.security.constant.UniqueMobile;
import com.github.user.manager.security.constant.UniqueUsername;
import lombok.Data;

/**
 * @author 石少东
 * @date 2020-08-24 16:15
 * @since 1.0
 */


@Data
public class UserRegisterDTO {

    @UniqueUsername
    private String username;

    private String password;

    @UniqueMobile
    private String mobile;

    private String email;

    private String note;

}
