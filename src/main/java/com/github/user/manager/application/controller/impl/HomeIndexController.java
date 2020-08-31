package com.github.user.manager.application.controller.impl;

import com.google.common.collect.Maps;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 * @author 石少东
 * @date 2020-08-30 14:52
 * @since 1.0
 */

@RestController
public class HomeIndexController {

    @Resource
    private HttpSecurity httpSecurity;

    @GetMapping("/home1")
    public String home1() {
        return "home1";
    }

    @GetMapping("/home2")
    public String home2() {
        return "home2";
    }


    @GetMapping("/1")
    public String r1() throws Exception {
        sec("/home1", "ROLE_ROOT");
        return "r1";
    }

    @GetMapping("/2")
    public String r2() throws Exception {
        sec("/home1", "ROLE_USER");
        return "r2";
    }


    private void sec(String ant, String roles) throws Exception {
        httpSecurity.authorizeRequests().antMatchers(HttpMethod.GET, ant).hasAnyRole(roles);
    }
//
//    private final Map<RequestMatcher, Collection<ConfigAttribute>> requestMap1 = Maps.newHashMap();
//    private final Map<RequestMatcher, Collection<ConfigAttribute>> requestMap2 = Maps.newHashMap();
//
//    @PostConstruct
//    public void init() {
//        requestMap1.put(new AntPathRequestMatcher("/home1", HttpMethod.GET.name()), Collections.singleton((ConfigAttribute) () -> "ROLE_ROOT"));
//        requestMap1.put(new AntPathRequestMatcher("/home2", HttpMethod.GET.name()), Collections.singleton((ConfigAttribute) () -> "ROLE_ROOT"));
//
//        requestMap2.put(new AntPathRequestMatcher("/home1", HttpMethod.GET.name()), Collections.singleton((ConfigAttribute) () -> "ROLE_USER"));
//        requestMap2.put(new AntPathRequestMatcher("/home2", HttpMethod.GET.name()), Collections.singleton((ConfigAttribute) () -> "ROLE_USER"));
//
//
//    }

}
