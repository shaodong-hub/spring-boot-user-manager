package com.github.user.manager.security.core.custom;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author 石少东
 * @date 2020-08-24 12:47
 * @since 1.0
 */

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public @NotNull Optional<String> getCurrentAuditor() {
        return Optional.of("default");
    }

}
