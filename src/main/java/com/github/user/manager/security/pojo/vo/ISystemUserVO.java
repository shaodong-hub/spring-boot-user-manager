package com.github.user.manager.security.pojo.vo;

import java.io.Serializable;

/**
 * @author 石少东
 * @date 2020-08-24 15:32
 * @since 1.0
 */


public interface ISystemUserVO extends Serializable {

    String getUsername();

    String getMobile();

    String getEmail();
}
