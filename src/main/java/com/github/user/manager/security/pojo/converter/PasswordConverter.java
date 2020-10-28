package com.github.user.manager.security.pojo.converter;

import io.micrometer.core.instrument.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.AttributeConverter;

/**
 * @author 石少东
 * @date 2020-08-22 16:54
 * @since 1.0
 */


@Slf4j
@RequiredArgsConstructor
public class PasswordConverter implements AttributeConverter<String, String> {

    private final PasswordEncoder encoder;

    @Override
    public String convertToDatabaseColumn(String attribute) {
        if (StringUtils.isNotBlank(attribute)) {
            return encoder.encode(attribute);
        }
        return "";
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return dbData;
    }


}
