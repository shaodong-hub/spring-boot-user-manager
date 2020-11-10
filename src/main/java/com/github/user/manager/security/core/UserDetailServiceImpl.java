package com.github.user.manager.security.core;

import com.github.user.manager.security.repository.IUserRepository;
import com.github.user.manager.security.service.manager.IManagerUserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author 石少东
 * @date 2020-08-22 17:18
 * @since 1.0
 */


@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final IUserRepository repository;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDetails> optional = repository.findByUsernameEquals(username);
        optional.orElseThrow((Supplier<Throwable>) () -> new UsernameNotFoundException("找不到这个用户"));
        return optional.get();
    }
}
