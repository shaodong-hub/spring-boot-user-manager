package com.github.user.manager.security.service.manager.impl;

import com.github.user.manager.security.pojo.orm.SystemResourceDO;
import com.github.user.manager.security.pojo.vo.ISystemSimpleResourceVO;
import com.github.user.manager.security.repository.IResourceRepository;
import com.github.user.manager.security.service.manager.IManagerResourceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 石少东
 * @date 2020-11-10 11:07
 * @since 1.0
 */

@Service
public class ManagerResourceServiceImpl implements IManagerResourceService {

    @Resource
    private IResourceRepository repository;

    @Override
    public Page<ISystemSimpleResourceVO> listResourcesByParentId(Long parentId, Pageable pageable) {
        return repository.findAllByForeignKeyParentResourceIdIs(parentId, pageable);
    }

    @Override
    public SystemResourceDO create(SystemResourceDO resource) {
        return repository.save(resource);
    }

    @Override
    public SystemResourceDO update(SystemResourceDO resource) {
        return repository.save(resource);
    }

    @Override
    public Void deleteById(SystemResourceDO resource) {
        repository.delete(resource);
        return null;
    }
}
