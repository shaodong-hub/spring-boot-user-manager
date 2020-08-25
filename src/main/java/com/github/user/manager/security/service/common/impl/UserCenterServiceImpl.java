package com.github.user.manager.security.service.common.impl;

import com.github.user.manager.security.pojo.dto.ChangePasswordDTO;
import com.github.user.manager.security.pojo.dto.SystemUserDTO;
import com.github.user.manager.security.pojo.vo.ISystemUserVO;
import com.github.user.manager.security.repository.IUserRepository;
import com.github.user.manager.security.service.common.IUserCenterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

/**
 * @author 石少东
 * @date 2020-08-24 16:12
 * @since 1.0
 */


@Slf4j
@RequiredArgsConstructor
@Service
public class UserCenterServiceImpl implements IUserCenterService {

    private final IUserRepository repository;

    @Override
    public ISystemUserVO me() {
        return repository.findCurrentUser(ISystemUserVO.class);
    }

    @Override
    public Void changePassword(@NotNull ChangePasswordDTO resetPassword) {
        repository.updateCurrentPassword(resetPassword.getPasswordNew1());
        return null;
    }

    @Override
    public Void updateUserInfo(SystemUserDTO systemUser) {
        return null;
    }
}
