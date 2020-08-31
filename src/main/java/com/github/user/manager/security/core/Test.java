package com.github.user.manager.security.core;


import org.joor.Reflect;
import org.springframework.context.ApplicationContext;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

import javax.annotation.Resource;

/**
 * @author 石少东
 * @date 2020-08-30 15:46
 * @since 1.0
 */


public class Test {

    ExpressionUrlAuthorizationConfigurer.AuthorizedUrl authorizedUrl;
    @Resource
    private ApplicationContext context;

    void main(ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry REGISTRY){
        ExpressionUrlAuthorizationConfigurer<HttpSecurity> configurer = new ExpressionUrlAuthorizationConfigurer<>(context);
//        Reflect.on(configurer).


    }

}
