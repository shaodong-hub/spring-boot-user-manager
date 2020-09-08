package com.github.user.manager.security.pojo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author 石少东
 * @date 2020-08-24 15:34
 * @since 1.0
 */


@Data
@EqualsAndHashCode(callSuper = false)
public class SystemUserDTO implements Serializable {

    private static final long serialVersionUID = 8244210886033431393L;

    private String username;

    private String mobile;

    private String password;

    private String email;

    private String note;

}
