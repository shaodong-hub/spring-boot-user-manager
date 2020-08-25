package com.github.user.manager.security.constant.validator;


import com.github.user.manager.security.constant.ChangePassword;
import com.github.user.manager.security.pojo.dto.ChangePasswordDTO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author 石少东
 * @date 2020-06-16 17:41
 */

@RequiredArgsConstructor
public class ResetPasswordValidator implements ConstraintValidator<ChangePassword, ChangePasswordDTO> {

    @Override
    public boolean isValid(@NotNull ChangePasswordDTO value, ConstraintValidatorContext context) {
        return StringUtils.equals(value.getPasswordNew1(),value.getPasswordNew2());
    }

}
