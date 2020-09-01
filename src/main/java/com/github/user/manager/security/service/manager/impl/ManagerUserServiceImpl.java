package com.github.user.manager.security.service.manager.impl;

import com.github.user.manager.security.pojo.dto.SystemUserDTO;
import com.github.user.manager.security.pojo.orm.SystemUserDO;
import com.github.user.manager.security.pojo.vo.ISystemDetailUserVO;
import com.github.user.manager.security.repository.IUserRepository;
import com.github.user.manager.security.service.manager.IManagerUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    @Override
    public Page<ISystemDetailUserVO> findAllUsers(Pageable pageable) {
        return userJpaRepository.findAllBy(pageable, ISystemDetailUserVO.class);
    }

    @Cacheable
    @Override
    public ISystemDetailUserVO findByUserByUsername(String username) {
        return userJpaRepository.findByUsernameIs(username, ISystemDetailUserVO.class);
    }

    @Caching(
            put = {@CachePut(key = "#result.username")},
            evict = {@CacheEvict(key = "'[' + #a0.username + ']'")}
    )
    @Override
    public ISystemDetailUserVO createUser(SystemUserDTO user) {
        SystemUserDO systemUser = getSystemUserFromDTO(user);
        return null;
    }

    @CacheEvict(key = "#a0.username")
    @Override
    public void deleteUser(SystemUserDO user) {
        userJpaRepository.delete(user);
    }

    private SystemUserDO getSystemUserFromDTO(SystemUserDTO user) {
        return new SystemUserDO();
    }


}