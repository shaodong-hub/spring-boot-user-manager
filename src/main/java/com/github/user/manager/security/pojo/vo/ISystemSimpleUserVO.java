package com.github.user.manager.security.pojo.vo;

import com.github.user.manager.security.pojo.orm.SystemRoleDO;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @author 石少东
 * @date 2020-08-24 15:32
 * @since 1.0
 */


public interface ISystemSimpleUserVO extends IBaseEntityVO, Serializable {

    String getUuid();

    String getOpenId();

    String getUsername();

    String getMobile();

    String getPassword();

    String getEmail();

    Date getAccountNonExpired();

    Date getAccountNonLocked();

    Date getCredentialsNonExpired();

    Date getLastLoginDate();
}
