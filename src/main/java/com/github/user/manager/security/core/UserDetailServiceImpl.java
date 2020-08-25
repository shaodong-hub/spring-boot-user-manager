package com.github.user.manager.security.core;

import com.github.user.manager.security.pojo.orm.SystemUserDO;
import com.github.user.manager.security.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author 石少东
 * @date 2020-08-22 17:18
 * @since 1.0
 */


@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final IUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SystemUserDO> optional = repository.findByUsernameEquals(username);
        if (!optional.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        return optional.get();
    }
}
