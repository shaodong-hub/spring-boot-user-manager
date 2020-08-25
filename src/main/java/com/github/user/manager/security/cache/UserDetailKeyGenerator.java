package com.github.user.manager.security.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author 石少东
 * @date 2020-08-24 16:59
 * @since 1.0
 */

@Slf4j
@Configuration
public class UserDetailKeyGenerator {

    /**
     * 创建默认
     *
     * @return KeyGenerator
     */
    @Bean("DefaultGenerator")
    public KeyGenerator defaultGenerator() {
        log.info("创建 DefaultGenerator!");
        return (target, method, params) -> Arrays.asList(params).toString();
    }


    /**
     * 创建默认
     *
     * @return KeyGenerator
     */
    @Bean("UserGenerator")
    public KeyGenerator userGenerator() {
        log.info("创建 DefaultGenerator!");
        return (target, method, params) -> params;
    }
}
