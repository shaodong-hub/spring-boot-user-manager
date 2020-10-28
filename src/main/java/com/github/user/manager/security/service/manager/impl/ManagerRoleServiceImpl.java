package com.github.user.manager.security.service.manager.impl;

import com.github.user.manager.security.pojo.dto.SystemRoleDTO;
import com.github.user.manager.security.pojo.vo.ISystemDetailRoleVO;
import com.github.user.manager.security.repository.IRoleRepository;
import com.github.user.manager.security.service.manager.IManagerRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageImpl;
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

    @Cacheable(key = "#a0.pageNumber + ':' + #a0.pageSize + ':' + #a0.sort")
    @Override
    public PageImpl<ISystemDetailRoleVO> findAllRoles(Pageable pageable) {
        return roleRepository.findAllBy(pageable);
    }

    @Cacheable
    @Override
    public ISystemDetailRoleVO findByRoleById(Long roleId) {
        return roleRepository.findByIdEquals(roleId);
    }

    @Override
    public void createRole(SystemRoleDTO role) {

    }

    @CacheEvict
    @Override
    public void deleteRoleById(Long roleId) {
        roleRepository.deleteById(roleId);
    }
}


