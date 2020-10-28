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

    /**
     * 只要是有一个赞成就授权
     *
     * @param decisionVoters List
     * @return AffirmativeBased
     */
    @Bean
    public AffirmativeBased affirmativeBased(List<AccessDecisionVoter<?>> decisionVoters) {
        return new AffirmativeBased(decisionVoters);
    }

    /**
     * 使用提供的角色投票器，
     *
     * @return 角色投票器
     */
    @Bean
    public AccessDecisionVoter<Object> accessDecisionVoter() {
        return new RoleVoter();
    }

}
