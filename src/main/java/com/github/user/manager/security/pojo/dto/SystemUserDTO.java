package com.github.user.manager.security.pojo.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.user.manager.security.pojo.view.ICreateView;
import com.github.user.manager.security.pojo.view.IUpdateView;
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

    @JsonView(IUpdateView.class)
    private Long id;

    @JsonView(ICreateView.class)
    private String username;

    @JsonView(ICreateView.class)
    private String mobile;

    @JsonView(ICreateView.class)
    private String password;

    @JsonView(ICreateView.class)
    private String email;

    @JsonView(ICreateView.class)
    private String note;

}
