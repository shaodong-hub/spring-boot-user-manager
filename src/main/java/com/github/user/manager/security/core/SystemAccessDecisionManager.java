package com.github.user.manager.security.core;

import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 石少东
 * @date 2020-08-28 17:57
 * @since 1.0
 */

@Component
public class SystemAccessDecisionManager {

    @Bean
    public AffirmativeBased affirmativeBased(List<AccessDecisionVoter<?>> decisionVoters) {
        return new AffirmativeBased(decisionVoters);
    }

    @Bean
    public AccessDecisionVoter<Object> accessDecisionVoter() {
        return new RoleVoter();
    }

}
