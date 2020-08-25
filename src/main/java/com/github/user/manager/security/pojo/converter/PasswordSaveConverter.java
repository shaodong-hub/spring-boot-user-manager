package com.github.user.manager.security.pojo.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.user.manager.security.pojo.bo.PasswordBO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;

/**
 * @author 石少东
 * @date 2020-08-22 16:54
 * @since 1.0
 */


@Slf4j
@RequiredArgsConstructor
public class PasswordSaveConverter implements AttributeConverter<PasswordBO, String> {

    private final ObjectMapper objectMapper;

    @Override
    @SneakyThrows(JsonProcessingException.class)
    public String convertToDatabaseColumn(PasswordBO attribute) {
        return objectMapper.writeValueAsString(attribute);
    }

    @Override
    @SneakyThrows(JsonProcessingException.class)
    public PasswordBO convertToEntityAttribute(String dbData) {
        return objectMapper.readValue(dbData, PasswordBO.class);
    }
}
