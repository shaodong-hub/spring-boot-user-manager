package com.github.user.manager.security.controller.manager;

import com.github.user.manager.security.pojo.dto.SystemResourceDTO;
import com.github.user.manager.security.pojo.orm.SystemResourceDO;
import com.github.user.manager.security.pojo.vo.ISystemSimpleResourceVO;
import com.github.user.manager.security.pojo.vo.ResultVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author 石少东
 * @date 2020-11-05 11:09
 * @since 1.0
 */


public interface IManagerResourceController<T extends SystemResourceDTO> {

    ResultVO<Page<ISystemSimpleResourceVO>> listResourcesByParentId(Long id, Pageable pageable);

    ResultVO<SystemResourceDO> create(SystemResourceDO resource);

    ResultVO<SystemResourceDO> update(SystemResourceDO resource);

    ResultVO<Void> deleteById(SystemResourceDO resource);


}
