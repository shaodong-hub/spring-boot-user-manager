package com.github.user.manager.security.controller.manager;

import com.github.user.manager.security.pojo.dto.SystemRoleDTO;
import com.github.user.manager.security.pojo.vo.ISystemRoleVO;
import com.github.user.manager.security.pojo.vo.ResultVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

/**
 * @author 石少东
 * @date 2020-08-24 15:31
 * @since 1.0
 */


public interface IManagerRoleController<T extends SystemRoleDTO> {

    /**
     * 查找所有的角色
     *
     * @param pageable 分页信息
     * @return Page
     */
    ResultVO<Page<ISystemRoleVO>> findAllRoles(@PageableDefault(direction = Sort.Direction.DESC, sort = "createDate") Pageable pageable);

    /**
     * 根据ID查找角色
     *
     * @param roleId 角色信息
     * @return SystemRoleVO
     */
    ResultVO<ISystemRoleVO> findByRoleById(Long roleId);

    /**
     * 创建新用户
     *
     * @param role 用户信息
     * @return SystemRoleVO
     */
    ResultVO<Void> createRole(T role);

    /**
     * 根据ID删除用户
     *
     * @param roleId 用户信息
     * @return Void
     */
    ResultVO<Void> deleteRoleById(Long roleId);


}
