package com.github.user.manager.security.pojo.vo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Map;

/**
 * @author 石少东
 * @date 2020-08-24 15:32
 * @since 1.0
 */

@JsonDeserialize(as = ISystemDetailUserVO.SystemDetailUserVO.class)
public interface ISystemDetailUserVO extends ISystemSimpleUserVO, Cloneable {

    /**
     * 用户的角色
     *
     * @return Map
     */
    @JsonManagedReference
    Map<Long, ISystemDetailRoleVO> getRoles();

    @Getter
    @Setter
    @ToString
    class SystemDetailUserVO implements ISystemDetailUserVO {

        private static final long serialVersionUID = 8416030246671120764L;

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

        private Map<Long, ISystemDetailRoleVO> roles;
    }

}
