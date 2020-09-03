package com.github.user.manager.security.pojo.orm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.github.user.manager.security.pojo.bo.PasswordBO;
import com.github.user.manager.security.pojo.converter.PasswordConverter;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.github.user.manager.security.pojo.common.OrmTableName.SYSTEM_USER;
import static com.github.user.manager.security.pojo.common.OrmTableName.USER_ROLE;

/**
 * @author 石少东
 * @date 2020-08-22 16:49
 * @since 1.0
 */

@SuppressWarnings("unused")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = SYSTEM_USER, indexes = {
        @Index(columnList = "uuid", name = "IDX_UUID", unique = true),
        @Index(columnList = "open_id", name = "IDX_OPENID", unique = true),
        @Index(columnList = "username", name = "IDX_USERNAME", unique = true),
        @Index(columnList = "mobile", name = "IDX_MOBILE", unique = true),
})
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "SystemUserDO")
public class SystemUserDO extends BaseEntity implements UserDetails {

    private static final long serialVersionUID = 6949655530047745714L;

    private String uuid;

    @Column(name = "open_id", columnDefinition = "VARCHAR(255) COMMENT '密码'")
    private String openId;

    @Column(columnDefinition = "VARCHAR(20) COMMENT '用户名'")
    private String username;

    @Column(columnDefinition = "VARCHAR(20) COMMENT '手机号码'")
    private String mobile;

    @JsonIgnore
    @Column(columnDefinition = "VARCHAR(255) COMMENT '密码'")
    @Convert(converter = PasswordConverter.class)
    private String password;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '邮箱'")
    private String email;

    @MapKey
    @ManyToMany(targetEntity = SystemRoleDO.class, cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(
            name = USER_ROLE,
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    @JsonManagedReference
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "SystemRoleDO")
    private Map<Long, SystemRoleDO> roles;

    @JsonIgnore
    @Column(name = "account_non_expired", columnDefinition = "VARCHAR(100) COMMENT '账户没有过期'")
    private Date accountNonExpired;

    @JsonIgnore
    @Column(name = "account_non_locked", columnDefinition = "VARCHAR(100) COMMENT '账户没有被锁定'")
    private Date accountNonLocked;

    @JsonIgnore
    @Column(name = "credentials_non_expired", columnDefinition = "VARCHAR(100) COMMENT '凭证没有过期'")
    private Date credentialsNonExpired;

    @JsonIgnore
    @Column(name = "last_login_date", columnDefinition = "DATETIME COMMENT '最后登录时间'")
    private Date lastLoginDate;

    @JsonIgnore
    @Column(name = "history_password", columnDefinition = "TEXT COMMENT '历史密码'")
    private PasswordBO historyPassword;

    @JsonIgnore
    @Override
    public Collection<SystemRoleDO> getAuthorities() {
        return roles.values();
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        if (null == accountNonExpired) {
            return true;
        } else {
            return accountNonExpired.before(new Date());
        }
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        if (null == accountNonLocked) {
            return true;
        } else {
            return accountNonLocked.before(new Date());
        }
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return super.getEnabled();
    }

}
