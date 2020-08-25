package com.github.user.manager.security.initializer;

import com.github.user.manager.security.pojo.orm.SystemRoleDO;
import com.github.user.manager.security.pojo.orm.SystemUserDO;
import com.github.user.manager.security.repository.IRoleRepository;
import com.github.user.manager.security.repository.IUserRepository;
import com.google.common.collect.Maps;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Map;

/**
 * @author 石少东
 * @date 2020-08-22 17:22
 * @since 1.0
 */


@Slf4j
@Order(1)
@Configuration
@RequiredArgsConstructor
public class SystemContextInitializer implements CommandLineRunner {

    private final IUserRepository userRepository;

    private final IRoleRepository roleRepository;

    @Override
    public void run(String... args) {
        SystemRoleDO role = roleRepository.save(getRole());
        Map<Long, SystemRoleDO> map = Maps.newHashMap();
        map.put(role.getId(), role);
        SystemUserDO user = getUser();
        user.setRoles(map);
        userRepository.save(user);
    }

    private SystemRoleDO getRole() {
        return SystemRoleDO.builder().roleName("超管").roleCode("ROLE_ROOT").build();
    }

    private SystemUserDO getUser() {
        SystemUserDO user = SystemUserDO.builder()
                .username("root")
                .mobile("18812345678")
                .build();
        user.setPassword("123456");
        return user;
    }

}
