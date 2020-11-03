package com.github.user.manager.security.service.manager.impl;

import com.github.user.manager.security.pojo.dto.SystemUserDTO;
import com.github.user.manager.security.pojo.dto.UserQueryConditionsDTO;
import com.github.user.manager.security.pojo.orm.SystemUserDO;
import com.github.user.manager.security.pojo.vo.ISystemDetailUserVO;
import com.github.user.manager.security.repository.IUserRepository;
import com.github.user.manager.security.service.manager.IManagerUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author 石少东
 * @date 2020-08-24 15:38
 * @since 1.0
 */


@Slf4j
@RequiredArgsConstructor
@Service
@CacheConfig(cacheNames = "user", keyGenerator = "RedisGenerator")
public class ManagerUserServiceImpl implements IManagerUserService {

    private final IUserRepository userJpaRepository;

    @Cacheable
    @Override
    public Optional<UserDetails> loadUserByUsername(String username) {
        return userJpaRepository.findByUsernameEquals(username);
    }

    @Override
    public Page<SystemUserDO> findAllUsers(UserQueryConditionsDTO query, Pageable pageable) {
        return userJpaRepository.findAll(specification(query), pageable);
    }

    @Cacheable
    @Override
    public ISystemDetailUserVO findByUserByUsername(String username) {
        return userJpaRepository.findByUsernameIs(username);
    }

    @Caching(
            put = {@CachePut(key = "#result.username"), @CachePut(key = "#result.mobile")},
            evict = {@CacheEvict(key = "'[' + #a0.username + ']'")}
    )
    @Override
    public ISystemDetailUserVO createUser(SystemUserDTO user) {
        SystemUserDO systemUser = getSystemUserFromDTO(user);
        userJpaRepository.save(systemUser);
        return null;
    }

    @Caching(
            put = {@CachePut(key = "#result.username"), @CachePut(key = "#result.mobile")},
            evict = {@CacheEvict(key = "'[' + #a0.username + ']'")}
    )
    @Override
    public ISystemDetailUserVO updateUser(SystemUserDTO user) {
        Optional<SystemUserDO> optional = userJpaRepository.findById(user.getId());
        optional.ifPresent(one -> {
            BeanUtils.copyProperties(user, one);
            userJpaRepository.save(one);
        });
        return null;
    }

    @CacheEvict(key = "#a0.username")
    @Override
    public void deleteUser(SystemUserDO user) {
        userJpaRepository.delete(user);
    }


    private Specification<SystemUserDO> specification(UserQueryConditionsDTO conditions) {
        return (Specification<SystemUserDO>) (root, query, builder) -> {
            List<Predicate> list = new ArrayList<>();
            if (StringUtils.isNotBlank(conditions.getUsername())) {
                list.add(builder.like(root.get("username").as(String.class), conditions.getUsername()));
            }
            if (!ObjectUtils.isEmpty(conditions.getStartDate()) && !ObjectUtils.isEmpty(conditions.getEndDate())) {
                list.add(builder.between(root.get("age").as(Date.class), conditions.getStartDate(), conditions.getEndDate()));
            }
            Predicate[] predicates = list.toArray(new Predicate[0]);
            return query.where(predicates).getRestriction();
        };
    }


    private SystemUserDO getSystemUserFromDTO(SystemUserDTO user) {
        SystemUserDO userDO = new SystemUserDO();
        BeanUtils.copyProperties(user, userDO);
        return userDO;
    }

}