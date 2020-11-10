package com.github.user.manager.security.controller.manager.impl;

import com.github.user.manager.security.controller.manager.IManagerResourceController;
import com.github.user.manager.security.pojo.dto.SystemResourceDTO;
import com.github.user.manager.security.pojo.orm.SystemResourceDO;
import com.github.user.manager.security.pojo.vo.ISystemSimpleResourceVO;
import com.github.user.manager.security.pojo.vo.ResultVO;
import com.github.user.manager.security.service.manager.IManagerResourceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author 石少东
 * @date 2020-11-05 11:09
 * @since 1.0
 */


@RestController
public class ManagerResourceControllerImpl implements IManagerResourceController<SystemResourceDTO> {

    @Resource
    private IManagerResourceService service;

    @Override
    public ResultVO<Page<ISystemSimpleResourceVO>> listResourcesByParentId(Long id, Pageable pageable) {
        return ResultVO.success(service.listResourcesByParentId(id, pageable));
    }

    @Override
    public ResultVO<SystemResourceDO> create(SystemResourceDO resource) {
        return ResultVO.success(service.create(resource));
    }

    @Override
    public ResultVO<SystemResourceDO> update(SystemResourceDO resource) {
        return ResultVO.success(service.update(resource));
    }

    @Override
    public ResultVO<Void> deleteById(SystemResourceDO resource) {
        return ResultVO.success(service.deleteById(resource));
    }
}
