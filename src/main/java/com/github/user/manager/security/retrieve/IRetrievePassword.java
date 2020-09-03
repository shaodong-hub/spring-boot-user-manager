package com.github.user.manager.security.retrieve;

import com.github.user.manager.security.pojo.dto.PasswordRetrieveDTO;
import com.github.user.manager.security.pojo.vo.RetrieveMessageVO;

/**
 * @author 石少东
 * @date 2020-08-24 16:20
 * @since 1.0
 */


@FunctionalInterface
public interface IRetrievePassword {

    /**
     * 找回密码，具体实现由子类实现
     *
     * @param password 找回密码信息
     * @return RetrieveMessageVO
     */
    RetrieveMessageVO retrieve(PasswordRetrieveDTO password);

}
