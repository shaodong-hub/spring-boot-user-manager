package com.github.user.manager.security.controller.manager;

import com.github.user.manager.security.pojo.dto.SystemUserDTO;
import com.github.user.manager.security.pojo.orm.SystemUserDO;
import com.github.user.manager.security.pojo.vo.ISystemDetailUserVO;
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


public interface IManagerUserController<T extends ISystemDetailUserVO, E> {

    /**
     * 分页查找所有的用户
     *
     * @param pageable 分页信息
     * @return Page
     */
    ResultVO<Page<T>> findAllUsers(@PageableDefault(direction = Sort.Direction.DESC, sort = "createDate") Pageable pageable);

    /**
     * 根据用户名查找用户
     *
     * @param username 用户名
     * @return ResultVO
     */
    ResultVO<T> findByUserByUsername(String username);

    /**
     * 创建用户
     *
     * @param user 用户信息
     * @return ResultVO
     */
    ResultVO<T> createUser(SystemUserDTO user);

    /**
     * 根据用户的 ID 删除用户
     *
     * @param user 用户信息
     * @return ResultVO
     */
    ResultVO<Void> deleteUserById(SystemUserDO user);
}
