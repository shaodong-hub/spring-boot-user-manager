package com.github.user.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author 石少东
 */

@EnableRedisHttpSession
@EnableJpaAuditing
@SpringBootApplication
public class SpringBootUserManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootUserManagerApplication.class, args);
    }

}
