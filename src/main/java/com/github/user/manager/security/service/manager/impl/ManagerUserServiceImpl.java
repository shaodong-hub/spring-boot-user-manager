package com.github.user.manager.security.service.manager.impl;

import com.github.user.manager.security.pojo.dto.SystemUserDTO;
import com.github.user.manager.security.pojo.orm.SystemUserDO;
import com.github.user.manager.security.pojo.vo.ISystemDetailUserVO;
import com.github.user.manager.security.repository.IUserRepository;
import com.github.user.manager.security.service.manager.IManagerUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author 石少东
 * @date 2020-08-24 15:38
 * @since 1.0
 */


@Slf4j
@RequiredArgsConstructor
@Service
@CacheConfig(cacheNames = "user", keyGenerator = "RedisGenerator")
public class ManagerUserServiceImpl implements IManagerUserService {

    private final IUserRepository userJpaRepository;

    @Cacheable
    @Override
    public Optional<UserDetails> loadUserByUsername(String username) {
        return userJpaRepository.findByUsernameEquals(username);
    }

    @Cacheable(key = "#a0.pageNumber + ':' + #a0.pageSize + ':' + #a0.sort")
    @Override
    public PageImpl<ISystemDetailUserVO> findAllUsers(Pageable pageable) {
        return userJpaRepository.findAllBy(pageable);
    }

    @Cacheable
    @Override
    public ISystemDetailUserVO findByUserByUsername(String username) {
        return userJpaRepository.findByUsernameIs(username);
    }

    @Caching(
            put = {@CachePut(key = "#result.username")},
            evict = {@CacheEvict(key = "'[' + #a0.username + ']'")}
    )
    @Override
    public ISystemDetailUserVO createUser(SystemUserDTO user) {
        SystemUserDO systemUser = getSystemUserFromDTO(user);
        userJpaRepository.save(systemUser);
        return null;
    }

    @CacheEvict(key = "#a0.username")
    @Override
    public void deleteUser(SystemUserDO user) {
        userJpaRepository.delete(user);
    }

    private SystemUserDO getSystemUserFromDTO(SystemUserDTO user) {
        SystemUserDO userDO = new SystemUserDO();
        BeanUtils.copyProperties(user, userDO);
        return userDO;
    }

}