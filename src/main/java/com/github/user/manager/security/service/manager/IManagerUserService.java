package com.github.user.manager.security.service.manager;

import com.github.user.manager.security.pojo.dto.SystemUserDTO;
import com.github.user.manager.security.pojo.orm.SystemUserDO;
import com.github.user.manager.security.pojo.vo.ISystemUserVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author 石少东
 * @date 2020-08-24 15:37
 * @since 1.0
 */


public interface IManagerUserService {

    /**
     * 查找所有的用户
     *
     * @param pageable 分页信息
     * @return Page
     */
    Page<ISystemUserVO> findAllUsers(Pageable pageable);

    /**
     * 根据用户名查找用户
     *
     * @param username 用户名
     * @return ISystemUserVO
     */
    ISystemUserVO findByUserByUsername(String username);

    /**
     * 创建新的用户
     *
     * @param user 用户信息
     * @return ISystemUserVO
     */
    ISystemUserVO createUser(SystemUserDTO user);

    /**
     * 删除用户
     *
     * @param user 用户
     * @return Void
     */
    void deleteUser(SystemUserDO user);
}