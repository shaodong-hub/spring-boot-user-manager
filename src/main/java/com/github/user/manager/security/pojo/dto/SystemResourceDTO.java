package com.github.user.manager.security.pojo.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.user.manager.security.pojo.view.ICreateView;
import com.github.user.manager.security.pojo.view.IUpdateView;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author 石少东
 * @date 2020-08-24 15:34
 * @since 1.0
 */


@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class SystemResourceDTO implements Serializable {

    private static final long serialVersionUID = 1244210886033431399L;


}
