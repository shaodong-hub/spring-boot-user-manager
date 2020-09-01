package com.github.user.manager.security.controller.common.impl;

import com.github.user.manager.security.controller.common.IUserCenterController;
import com.github.user.manager.security.pojo.dto.ChangePasswordDTO;
import com.github.user.manager.security.pojo.dto.SystemUserDTO;
import com.github.user.manager.security.pojo.vo.ISystemDetailUserVO;
import com.github.user.manager.security.pojo.vo.ResultVO;
import com.github.user.manager.security.service.common.IUserCenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 石少东
 * @date 2020-08-24 16:10
 * @since 1.0
 */



@RestController
@RequestMapping("/user/center")
@PreAuthorize("isFullyAuthenticated()")
@RequiredArgsConstructor
public class UserCenterControllerImpl implements IUserCenterController<ISystemDetailUserVO, SystemUserDTO<Void>,Void> {

    private final IUserCenterService service;

    @GetMapping("/me")
    @Override
    public ResultVO<ISystemDetailUserVO> me() {
        return ResultVO.success(service.me());
    }

    @PutMapping("/info")
    @Override
    public ResultVO<Void> updateUserInfo(@RequestBody SystemUserDTO<Void> systemUser) {
        return ResultVO.success(service.updateUserInfo(systemUser));
    }

    @PutMapping("/password/change")
    @Override
    public ResultVO<Void> changePassword(@RequestBody @Validated ChangePasswordDTO changePassword) {
        return ResultVO.success(service.changePassword(changePassword));
    }

}