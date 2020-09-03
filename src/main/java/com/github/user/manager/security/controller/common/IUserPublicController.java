package com.github.user.manager.security.controller.common;

import com.github.user.manager.security.constant.RetrieveType;
import com.github.user.manager.security.pojo.dto.PasswordResetDTO;
import com.github.user.manager.security.pojo.dto.PasswordRetrieveDTO;
import com.github.user.manager.security.pojo.dto.UserRegisterDTO;
import com.github.user.manager.security.pojo.vo.ResultVO;
import com.github.user.manager.security.pojo.vo.RetrieveMessageVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 石少东
 * @date 2020-08-24 16:09
 * @since 1.0
 */


public interface IUserPublicController<T extends UserRegisterDTO> {

    /**
     * 注册用户
     *
     * @param register 注册信息
     * @return Void
     */
    ResultVO<Void> register(@Validated T register);

    /**
     * 找回密码
     *
     * @param type     类型
     * @param retrieve 找回信息
     * @return RetrieveMessageVO
     */
    ResultVO<RetrieveMessageVO> retrievePassword(@RetrieveType String type, @RequestBody PasswordRetrieveDTO retrieve);


    ResultVO<Void> resetPassword(String randomString, PasswordResetDTO resetPassword);

}
