package com.github.user.manager.security.pojo.orm;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.Table;
import java.util.Map;

import static com.github.user.manager.security.pojo.common.OrmTableName.SYSTEM_ROLE;

/**
 * @author 石少东
 * @date 2020-08-22 16:50
 * @since 1.0
 */

@NamedEntityGraphs(value = {
        @NamedEntityGraph(name = "SystemRoleDO.findAllBy", attributeNodes = {@NamedAttributeNode("users")}),
})
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "SystemRoleDO")
@Entity
@Where(clause = "deleted = false or deleted is null")
@Table(name = SYSTEM_ROLE)
public class SystemRoleDO extends BaseEntity implements GrantedAuthority {

    private static final long serialVersionUID = -3157807413812174641L;

    @Column(name = "role_name", columnDefinition = "VARCHAR(20) COMMENT '角色名称'")
    private String roleName;

    @Column(name = "role_code", columnDefinition = "VARCHAR(20) COMMENT '角色编码'")
    private String roleCode;

    @MapKey
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    @JsonBackReference
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "SystemUserDO")
    private Map<Long, SystemUserDO> users;

//    @ManyToMany(targetEntity = SystemResourceDO.class, cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
//    @JoinTable(
//            name = ROLE_RESOURCE,
//            joinColumns = {@JoinColumn(name = "mid_role_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "mid_resource_id", referencedColumnName = "id")}
//    )
//    @JsonManagedReference
//    private Set<SystemResourceDO> systemResources;

    @JsonIgnore
    @Override
    public String getAuthority() {
        return roleCode;
    }

}