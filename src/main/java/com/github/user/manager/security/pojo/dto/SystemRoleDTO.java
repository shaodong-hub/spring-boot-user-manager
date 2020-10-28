package com.github.user.manager.security.pojo.dto;

import com.github.user.manager.security.pojo.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author 石少东
 * @date 2020-08-24 15:34
 * @since 1.0
 */

@Getter
@Setter
@ToString
public class SystemRoleDTO extends BaseEntity {

    private static final long serialVersionUID = -5420203406752206274L;

    private String roleName;

    private String roleCode;

}
