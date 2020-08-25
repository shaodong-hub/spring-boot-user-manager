package com.github.user.manager.security.pojo.bo;

import cn.hutool.core.map.FixedLinkedHashMap;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import static com.github.user.manager.security.core.password.ConfigUserPasswordEncoder.PASSWORD_ENCODER;

/**
 * @author 石少东
 * @date 2020-08-24 11:09
 * @since 1.0
 */


@Getter
@ToString
public class PasswordBO implements Serializable {

    private static final long serialVersionUID = -9435476556768879L;

    private String currentPassword;

    private final Map<Date, String> historyPassword = new FixedLinkedHashMap<>(5);

    public void setPassword(String password) {
        String encodePassword = PASSWORD_ENCODER.encode(password);
        this.historyPassword.put(new Date(), encodePassword);
        this.currentPassword = encodePassword;
    }

    public Boolean matchHistory(String password) {
        return historyPassword.values().stream().anyMatch(s -> PASSWORD_ENCODER.matches(password, s));
    }
}