package com.github.user.manager.security.controller.manager.impl;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.user.manager.security.controller.manager.IManagerUserController;
import com.github.user.manager.security.pojo.dto.SystemUserDTO;
import com.github.user.manager.security.pojo.dto.UserQueryConditionsDTO;
import com.github.user.manager.security.pojo.orm.SystemUserDO;
import com.github.user.manager.security.pojo.view.ICreateView;
import com.github.user.manager.security.pojo.view.IUpdateView;
import com.github.user.manager.security.pojo.vo.ISystemDetailUserVO;
import com.github.user.manager.security.pojo.vo.ResultVO;
import com.github.user.manager.security.service.manager.IManagerUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 石少东
 * @date 2020-08-24 15:36
 * @since 1.0
 */


@RestController
@PreAuthorize("hasRole('ROLE_ROOT')")
@RequestMapping("/manager/user")
@RequiredArgsConstructor
public class ManagerUserControllerImpl implements IManagerUserController<ISystemDetailUserVO, Void> {

    private final IManagerUserService service;

    @GetMapping("/users")
    @Override
    public ResultVO<Page<SystemUserDO>> findAllUsers(UserQueryConditionsDTO query,
                                                     @PageableDefault(direction = Sort.Direction.DESC, sort = "createDate") Pageable pageable) {
        return ResultVO.success(service.findAllUsers(query, pageable));
    }

    @GetMapping("/user/{username}")
    @Override
    public ResultVO<ISystemDetailUserVO> findByUserByUsername(@PathVariable String username) {
        return ResultVO.success(service.findByUserByUsername(username));
    }

    @PostMapping("/user")
    @Override
    public ResultVO<ISystemDetailUserVO> createUser(@JsonView(ICreateView.class) @RequestBody SystemUserDTO user) {
        return null;
    }

    @PutMapping("/user")
    @Override
    public ResultVO<ISystemDetailUserVO> updateUser(@JsonView(IUpdateView.class) @RequestBody SystemUserDTO user) {
        return null;
    }

    @DeleteMapping("/user/{id}")
    @Override
    public ResultVO<Void> deleteUserById(@PathVariable("id") SystemUserDO user) {
        service.deleteUser(user);
        return ResultVO.success();
    }

}
