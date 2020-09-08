package com.github.user.manager.security.core;

import com.github.user.manager.security.service.manager.IManagerUserService;
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

    private final IManagerUserService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDetails> optional = service.loadUserByUsername(username);
        if (!optional.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        return optional.get();
    }
}
