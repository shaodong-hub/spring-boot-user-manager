package com.github.user.manager.security.service.common.impl;

import com.github.user.manager.security.pojo.dto.RetrievePasswordDTO;
import com.github.user.manager.security.pojo.dto.UserRegisterDTO;
import com.github.user.manager.security.pojo.orm.SystemUserDO;
import com.github.user.manager.security.pojo.vo.RetrieveMessageVO;
import com.github.user.manager.security.repository.IUserRepository;
import com.github.user.manager.security.retrieve.IRetrievePassword;
import com.github.user.manager.security.service.common.IUserPublicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author 石少东
 * @date 2020-08-24 16:12
 * @since 1.0
 */

@Slf4j
@RequiredArgsConstructor
@Service
public class UserPublicServiceImpl implements IUserPublicService {

    private final IUserRepository repository;

    private final Map<String, IRetrievePassword> map;

    @Override
    public Void register(UserRegisterDTO register) {
        repository.save(getSystemUser(register));
        return null;
    }

    @Override
    public RetrieveMessageVO retrievePassword(String type, RetrievePasswordDTO retrieve) {
        return map.get(type).retrieve(retrieve);
    }

    private @NotNull SystemUserDO getSystemUser(UserRegisterDTO register) {
        SystemUserDO user = new SystemUserDO();
        BeanUtils.copyProperties(register, user);
        return user;
    }
}
