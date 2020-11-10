package com.github.user.manager.security.initializer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author 石少东
 * @date 2020-11-05 10:58
 * @since 1.0
 */

@Slf4j
@Order(1)
@Component("RequestMappingRunner")
@RequiredArgsConstructor
public class RequestMappingRunner  implements CommandLineRunner {

    private final RequestMappingHandlerMapping mapping;

    @Override
    public void run(String... args) throws Exception {

    }


}
