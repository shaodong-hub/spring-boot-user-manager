package com.github.user.manager.security.service.common;

import com.github.user.manager.security.pojo.dto.ChangePasswordDTO;
import com.github.user.manager.security.pojo.dto.SystemUserDTO;
import com.github.user.manager.security.pojo.vo.ISystemUserVO;

/**
 * @author 石少东
 * @date 2020-08-24 16:11
 * @since 1.0
 */


public interface IUserCenterService {

    ISystemUserVO me();

    Void changePassword(ChangePasswordDTO resetPassword);

    Void updateUserInfo(SystemUserDTO systemUser);
}
