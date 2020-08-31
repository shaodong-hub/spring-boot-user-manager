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
        saveUser("root", "188123456780", "ROLE_ROOT");
        saveUser("user", "188123456781", "ROLE_USER");
    }

    private void saveUser(String username, String mobile, String roleName) {
        SystemRoleDO role = roleRepository.save(getRole(roleName));
        Map<Long, SystemRoleDO> map = Maps.newHashMap();
        map.put(role.getId(), role);
        SystemUserDO user = getUser(username, mobile);
        user.setRoles(map);
        userRepository.save(user);
    }

    private SystemRoleDO getRole(String roleName) {
        return SystemRoleDO.builder().roleName(roleName).roleCode(roleName).build();
    }

    private SystemUserDO getUser(String username, String mobile) {
        SystemUserDO user = SystemUserDO.builder()
                .username(username)
                .mobile(mobile)
                .build();
        user.setPassword("123456");
        return user;
    }

}
