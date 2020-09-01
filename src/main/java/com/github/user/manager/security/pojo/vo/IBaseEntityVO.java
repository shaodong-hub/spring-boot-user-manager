package com.github.user.manager.security.pojo.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 石少东
 * @date 2020-09-01 15:54
 * @since 1.0
 */


public interface IBaseEntityVO extends Serializable {

    Long getId();

    Boolean getPreset();

    Boolean getEnabled();

    Boolean getDeleted();

    Date getCreateDate();

    Date getLastModifiedDate();

    String getCreateBy();

    String getLastModifiedBy();

    String getNote();

    Long getVersion();

}
