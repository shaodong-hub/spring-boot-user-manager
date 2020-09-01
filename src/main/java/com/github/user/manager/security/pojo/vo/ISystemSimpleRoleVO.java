package com.github.user.manager.security.pojo.vo;

import com.github.user.manager.security.pojo.orm.SystemUserDO;

import java.io.Serializable;
import java.util.Map;

/**
 * @author 石少东
 * @date 2020-08-24 15:32
 * @since 1.0
 */


public interface ISystemSimpleRoleVO extends IBaseEntityVO, Serializable {

    String getRoleName();

    String getRoleCode();

}
