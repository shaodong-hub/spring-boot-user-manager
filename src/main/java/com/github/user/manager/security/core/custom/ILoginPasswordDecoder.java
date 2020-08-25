package com.github.user.manager.security.core.custom;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 石少东
 * @date 2020-08-24 10:44
 * @since 1.0
 */


@FunctionalInterface
public interface ILoginPasswordDecoder {

    /**
     * 如果前端对用户密码进行了加密，后端需要对密码进行解密，集成的应用只要实现这个模块即可
     *
     * @param request           HttpServletRequest
     * @param encryptedPassword 前端已经加密好的密码
     * @return String
     */
    String decode(HttpServletRequest request, String encryptedPassword);

}
