package com.github.user.manager.security.repository;

import com.github.user.manager.security.pojo.orm.SystemRoleDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 石少东
 * @date 2020-08-22 17:19
 * @since 1.0
 */


public interface IRoleRepository extends JpaRepository<SystemRoleDO, Long> {

    @EntityGraph(value = "SystemRoleDO.findAllBy")
    <V> Page<V> findAllBy(Pageable pageable, Class<V> clz);

    <V> V findById(long id, Class<V> clz);
}
