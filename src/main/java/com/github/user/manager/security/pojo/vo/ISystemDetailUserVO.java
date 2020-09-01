package com.github.user.manager.security.pojo.vo;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Map;

/**
 * @author 石少东
 * @date 2020-08-24 15:32
 * @since 1.0
 */


public interface ISystemDetailUserVO extends ISystemSimpleUserVO {

    @JsonManagedReference
    Map<Long, ISystemDetailRoleVO> getRoles();
}
