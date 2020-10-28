package com.github.user.manager.security.core;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import static com.github.user.manager.security.common.ISecurityConstant.SYSTEM_LOGIN_USERNAME;

/**
 * @author 石少东
 * @date 2020-08-21 23:10
 * @since 1.0
 */

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
public class WebSecurityConfigurerAdapterConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    private final UserDetailsService userDetailsService;

    /**
     * 认证管理器配置方法
     * void configure(AuthenticationManagerBuilder auth) 用来配置认证管理器AuthenticationManager。
     * 说白了就是所有 UserDetails 相关的它都管，包含 PasswordEncoder 密码机。
     * 如果你不清楚可以通过 Spring Security 中的 UserDetail(https://www.felord.cn/spring-security-userdetails.html) 进行了解。
     * 本文对 AuthenticationManager 不做具体分析讲解，后面会有专门的文章来讲这个东西 。
     * 可通过 Spring Security 实战系列 进行学习。
     *
     * @param auth AuthenticationManagerBuilder
     * @throws Exception Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    /**
     * 安全过滤器链配置方法
     * void configure(HttpSecurity http) 这个是我们使用最多的，用来配置 HttpSecurity 。
     * HttpSecurity 用于构建一个安全过滤器链 SecurityFilterChain 。
     * SecurityFilterChain 最终被注入核心过滤器 。
     * HttpSecurity 有许多我们需要的配置。我们可以通过它来进行自定义安全访问策略。所以我们单独开一章来讲解这个东西。
     * http.csrf().csrfTokenRepository(new HttpSessionCsrfTokenRepository());
     *
     * @param http HttpSecurity
     * @throws Exception Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginProcessingUrl(SYSTEM_LOGIN_USERNAME).permitAll();
        http.authorizeRequests().anyRequest().authenticated();
        http.authorizeRequests().withObjectPostProcessor(new SystemObjectPostProcessor());
        http.csrf().disable();
    }

    /**
     * 核心过滤器配置方法
     * void configure(WebSecurity web) 用来配置 WebSecurity 。
     * 而 WebSecurity 是基于 Servlet Filter 用来配置 springSecurityFilterChain 。
     * 而 springSecurityFilterChain 又被委托给了 Spring Security 核心过滤器 Bean DelegatingFilterProxy 。
     * 相关逻辑你可以在 WebSecurityConfiguration 中找到。我们一般不会过多来自定义 WebSecurity ,
     * 使用较多的使其ignoring() 方法用来忽略 Spring Security 对静态资源的控制。
     *
     * @param web WebSecurity
     * @throws Exception Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    private AccessDecisionManager accessDecisionManager;

    private FilterInvocationSecurityMetadataSource metadataSource;

    @Autowired(required = false)
    public void setAccessDecisionManager(AccessDecisionManager accessDecisionManager) {
        this.accessDecisionManager = accessDecisionManager;
    }

    @Autowired(required = false)
    public void setMetadataSource(FilterInvocationSecurityMetadataSource metadataSource) {
        this.metadataSource = metadataSource;
    }

    @Order
    private class SystemObjectPostProcessor implements ObjectPostProcessor<FilterSecurityInterceptor> {

        @Override
        public <O extends FilterSecurityInterceptor> O postProcess(O fsi) {
            fsi.setSecurityMetadataSource(metadataSource);
            fsi.setAccessDecisionManager(accessDecisionManager);
            return fsi;
        }
    }

}
