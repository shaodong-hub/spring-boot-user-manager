package com.github.user.manager.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.security.config.annotation.SecurityConfigurer;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.web.access.expression.ExpressionBasedFilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 石少东
 * @date 2020-08-30 09:48
 * @since 1.0
 */

@Slf4j
@Component
public class ApplicationCommandLineRunner implements CommandLineRunner {

    @Resource
    private ApplicationContext context;

    @Resource
    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public void run(String... args) throws Exception {
        log.info("ApplicationCommandLineRunner");
//        registry1();
        registry2();
//        registry3();
//        UrlMapping
    }

    private void registry1() {
        Map<String, Object> map = context.getBeansOfType(Object.class);
        log.info("Object");
        map.forEach((k, v) -> System.out.println(k));
        System.out.println();
    }

    private void registry2() {
//        ExpressionUrlAuthorizationConfigurer
        System.out.println();
        Map<String, HttpSecurity> map = beanFactory.getBeansOfType(HttpSecurity.class);
        log.info("HttpSecurity");
        map.forEach((k, v) -> System.out.println(k));
    }

    private void registry3() {
        log.info("ExpressionUrlAuthorizationConfigurer");
        List<SecurityConfigurer<Filter, WebSecurity>> webSecurityConfigurers = new ArrayList<>();
        Map<String, WebSecurityConfigurer> beansOfType = beanFactory
                .getBeansOfType(WebSecurityConfigurer.class);
        for (Map.Entry<String, WebSecurityConfigurer> entry : beansOfType.entrySet()) {
            webSecurityConfigurers.add(entry.getValue());
        }

        log.info("ExpressionUrlAuthorizationConfigurer");
    }


}
