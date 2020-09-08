package com.github.user.manager.security.service.manager;

import com.github.user.manager.security.pojo.dto.SystemRoleDTO;
import com.github.user.manager.security.pojo.vo.ISystemDetailRoleVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

/**
 * @author 石少东
 * @date 2020-08-24 15:37
 * @since 1.0
 */


public interface IManagerRoleService {

    PageImpl<ISystemDetailRoleVO> findAllRoles(Pageable pageable);

    ISystemDetailRoleVO findByRoleById(Long roleId);

    void createRole(SystemRoleDTO role);

    void deleteRoleById(Long roleId);
}
