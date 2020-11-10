package com.github.user.manager.security.service.manager;

import com.github.user.manager.security.pojo.orm.SystemResourceDO;
import com.github.user.manager.security.pojo.vo.ISystemSimpleResourceVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author 石少东
 * @date 2020-11-10 11:07
 * @since 1.0
 */


public interface IManagerResourceService {

    Page<ISystemSimpleResourceVO> listResourcesByParentId(Long id, Pageable pageable);

    SystemResourceDO create(SystemResourceDO resource);

    SystemResourceDO update(SystemResourceDO resource);

    Void deleteById(SystemResourceDO resource);

}
