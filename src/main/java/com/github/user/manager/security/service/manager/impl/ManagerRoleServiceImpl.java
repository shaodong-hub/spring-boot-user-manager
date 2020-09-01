package com.github.user.manager.security.service.manager.impl;

import com.github.user.manager.security.pojo.dto.SystemRoleDTO;
import com.github.user.manager.security.pojo.vo.ISystemDetailRoleVO;
import com.github.user.manager.security.repository.IRoleRepository;
import com.github.user.manager.security.service.manager.IManagerRoleService;
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
@CacheConfig(cacheNames = "role", keyGenerator = "RedisGenerator")
public class ManagerRoleServiceImpl implements IManagerRoleService {

    private final IRoleRepository roleRepository;

    @Override
    public Page<ISystemDetailRoleVO> findAllRoles(Pageable pageable) {
        return roleRepository.findAllBy(pageable, ISystemDetailRoleVO.class);
    }

    @Cacheable
    @Override
    public ISystemDetailRoleVO findByRoleById(Long roleId) {
        return roleRepository.findById(roleId, ISystemDetailRoleVO.class);
    }

    @Caching(
            put = {@CachePut(key = "#result.username")},
            evict = {@CacheEvict(key = "'[' + #a0.username + ']'")}
    )
    @Override
    public void createRole(SystemRoleDTO user) {

    }

    @CacheEvict
    @Override
    public void deleteRoleById(Long roleId) {
        roleRepository.deleteById(roleId);
    }
}


