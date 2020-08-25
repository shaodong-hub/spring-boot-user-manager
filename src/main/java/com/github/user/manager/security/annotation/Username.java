package com.github.user.manager.security.annotation;

/**
 * @author 石少东
 * @date 2020-08-24 16:14
 * @since 1.0
 */

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@AuthenticationPrincipal(expression = "#this.username")
public @interface Username {
}
