package com.github.user.manager.security.constant;


import com.github.user.manager.security.constant.validator.ResetPasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 石少东
 * @date 2020-06-16 17:40
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Constraint(validatedBy = ResetPasswordValidator.class)
public @interface ChangePassword {

    String value() default "";

    String message() default "密码不正确";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
