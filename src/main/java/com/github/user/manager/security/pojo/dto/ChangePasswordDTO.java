package com.github.user.manager.security.pojo.dto;

import com.github.user.manager.security.constant.UserPassword;
import com.github.user.manager.security.constant.ChangePassword;
import lombok.Data;

/**
 * @author 石少东
 * @date 2020-08-24 16:13
 * @since 1.0
 */



@Data
@ChangePassword
public class ChangePasswordDTO {

    @UserPassword
    private String passwordOld;

    private String passwordNew1;

    private String passwordNew2;

}