package com.github.user.manager.security.pojo.dto;

import com.github.user.manager.security.pojo.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 石少东
 * @date 2020-08-24 15:34
 * @since 1.0
 */


@Data
@EqualsAndHashCode(callSuper = false)
public class SystemUserDTO<E> extends BaseEntity {

    private static final long serialVersionUID = 8244210886033431393L;

    private String username;

    private E optional;
}
