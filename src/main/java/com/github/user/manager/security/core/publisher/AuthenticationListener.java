package com.github.user.manager.security.core.publisher;

import com.github.user.manager.security.repository.IUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 石少东
 * @date 2020-08-24 12:50
 * @since 1.0
 */


@Slf4j
@Component
public class AuthenticationListener {

    @Resource
    private IUserRepository repository;

    @EventListener(InteractiveAuthenticationSuccessEvent.class)
    public void onSuccess() {
        log.info("AuthenticationSuccessEvent");
        repository.updateLastLoginDate();
    }

    @EventListener
    public void onFailure(AbstractAuthenticationFailureEvent failures) {
        log.info("AbstractAuthenticationFailureEvent");
    }
}