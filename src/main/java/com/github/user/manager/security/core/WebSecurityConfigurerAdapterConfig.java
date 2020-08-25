package com.github.user.manager.security.core;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

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

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginProcessingUrl(SYSTEM_LOGIN_USERNAME).permitAll();


//                .successHandler(successHandler)
//                .failureHandler(failureHandler)
//                .and()
//                .logout().logoutUrl(SecurityConstant.SYSTEM_LOGIN_LOGOUT)
//                .logoutSuccessHandler()

        http.authorizeRequests().anyRequest().authenticated();
        http.csrf().csrfTokenRepository(new HttpSessionCsrfTokenRepository());
    }

}
