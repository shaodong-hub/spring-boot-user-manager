package com.github.user.manager.security.controller.manager.impl;

import com.github.user.manager.security.controller.manager.IManagerRoleController;
import com.github.user.manager.security.pojo.dto.SystemRoleDTO;
import com.github.user.manager.security.pojo.vo.ISystemDetailRoleVO;
import com.github.user.manager.security.pojo.vo.ResultVO;
import com.github.user.manager.security.service.manager.IManagerRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 石少东
 * @date 2020-08-24 15:36
 * @since 1.0
 */


@RestController
@PreAuthorize("hasRole('ROLE_ROOT')")
@RequestMapping("/manager/role")
@RequiredArgsConstructor
public class ManagerRoleControllerImpl implements IManagerRoleController<SystemRoleDTO> {

    private final IManagerRoleService service;

    @GetMapping("roles")
    @Override
    public ResultVO<Page<ISystemDetailRoleVO>> findAllRoles(@PageableDefault(direction = Sort.Direction.DESC, sort = "createDate") Pageable pageable) {
        return ResultVO.success(service.findAllRoles(pageable));
    }

    @GetMapping("role/{id}")
    @Override
    public ResultVO<ISystemDetailRoleVO> findByRoleById(@PathVariable("id") Long roleId) {
        return ResultVO.success(service.findByRoleById(roleId));
    }

    @PostMapping("role")
    @Override
    public ResultVO<Void> createRole(SystemRoleDTO role) {
        service.createRole(role);
        return ResultVO.success();
    }

    @DeleteMapping("role/{id}")
    @Override
    public ResultVO<Void> deleteRoleById(@PathVariable("id") Long roleId) {
        service.deleteRoleById(roleId);
        return ResultVO.success();
    }
}
