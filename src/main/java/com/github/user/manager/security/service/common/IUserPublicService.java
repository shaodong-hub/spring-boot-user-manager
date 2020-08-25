package com.github.user.manager.security.service.common;

import com.github.user.manager.security.pojo.dto.RetrievePasswordDTO;
import com.github.user.manager.security.pojo.dto.UserRegisterDTO;
import com.github.user.manager.security.pojo.vo.RetrieveMessageVO;

/**
 * @author 石少东
 * @date 2020-08-24 16:11
 * @since 1.0
 */


public interface IUserPublicService {

    Void register(UserRegisterDTO register);

    RetrieveMessageVO retrievePassword(String type, RetrievePasswordDTO retrieve);
}
