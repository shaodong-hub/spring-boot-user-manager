package com.github.user.manager.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.security.config.annotation.SecurityConfigurer;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
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
    }

}
