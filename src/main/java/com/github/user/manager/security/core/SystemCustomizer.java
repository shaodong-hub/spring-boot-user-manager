package com.github.user.manager.security.core;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.stereotype.Component;

/**
 * @author 石少东
 * @date 2020-08-30 17:24
 * @since 1.0
 */

@Component
public class SystemCustomizer implements Customizer<ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry> {

    @Override
    public void customize(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry) {
//        SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> adapter = (SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>) expressionInterceptUrlRegistry;
        registry.antMatchers("").hasRole("");
    }



}
