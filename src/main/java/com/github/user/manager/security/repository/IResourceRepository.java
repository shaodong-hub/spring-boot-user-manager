package com.github.user.manager.security.repository;

import com.github.user.manager.security.pojo.orm.SystemResourceDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 石少东
 * @date 2020-09-09 14:35
 * @since 1.0
 */


public interface IResourceRepository extends JpaRepository<SystemResourceDO, Long> {

    <V> Page<V> findAllByForeignKeyParentResourceIdIs(Long parentId, Pageable pageable);


}
