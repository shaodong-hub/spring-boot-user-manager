package com.github.user.manager.security.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 石少东
 * @date 2020-08-24 15:32
 * @since 1.0
 */

@JsonDeserialize(as = ISystemSimpleUserVO.SystemSimpleUserVO.class)
public interface ISystemSimpleUserVO extends IBaseEntityVO, Cloneable, Serializable {

    String getUuid();

    String getOpenId();

    String getUsername();

    String getMobile();

    String getEmail();

    Date getLastLoginDate();

    @Getter
    @Setter
    @ToString
    class SystemSimpleUserVO implements ISystemSimpleUserVO {

        private static final long serialVersionUID = 6354964609853409039L;

        private Long id;

        private String uuid;

        private String openId;

        private String username;

        private String mobile;

        private String email;

        private Date lastLoginDate;

        private Boolean preset;

        private Boolean enabled;

        private Boolean deleted;

        private Date createDate;

        private Date lastModifiedDate;

        private String createBy;

        private String lastModifiedBy;

        private String note;

        private Long version;
    }

}
