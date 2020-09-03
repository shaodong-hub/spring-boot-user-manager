package com.github.user.manager.security.controller.common;

import com.github.user.manager.security.pojo.dto.PasswordChangeDTO;
import com.github.user.manager.security.pojo.dto.SystemUserDTO;
import com.github.user.manager.security.pojo.vo.ISystemDetailUserVO;
import com.github.user.manager.security.pojo.vo.ResultVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 石少东
 * @date 2020-08-24 16:09
 * @since 1.0
 */


public interface IUserCenterController<V extends ISystemDetailUserVO, T extends SystemUserDTO<E>, E> {

    /**
     * 获取当前用户信息
     *
     * @return ResultVO
     */
    ResultVO<V> me();

    /**
     * 更新用户信息
     *
     * @param systemUser 用户信息
     * @return Void
     */
    ResultVO<Void> updateUserInfo(@RequestBody T systemUser);

    /**
     * 重置密码
     *
     * @param resetPassword 重置密码
     * @return Void
     */
    ResultVO<Void> changePassword(@RequestBody @Validated PasswordChangeDTO resetPassword);

}