//package com.github.user.manager.security.pojo.orm;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//import org.hibernate.annotations.Cache;
//import org.hibernate.annotations.CacheConcurrencyStrategy;
//import org.hibernate.annotations.DynamicInsert;
//import org.hibernate.annotations.DynamicUpdate;
//import org.hibernate.annotations.Where;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//import org.springframework.http.HttpMethod;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EntityListeners;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Index;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.OrderBy;
//import javax.persistence.Table;
//
//import java.util.Set;
//
//import static com.github.user.manager.security.pojo.common.OrmTableName.SYSTEM_RESOURCE;
//
///**
// * @author 石少东
// * @date 2020-09-09 10:20
// * @since 1.0
// */
//
//@Getter
//@Setter
//@Builder
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
//@DynamicInsert
//@DynamicUpdate
//@EqualsAndHashCode(callSuper = true)
//@EntityListeners(AuditingEntityListener.class)
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "SystemResourceDO")
//@Entity
//@Where(clause = "deleted = false or deleted is null")
//@Table(name = SYSTEM_RESOURCE, indexes = {
//        @Index(columnList = "resource_code", name = "IDX_RESOURCE_CODE"),
//})
//public class SystemResourceDO extends BaseEntity {
//
//    private static final String FOREIGN_KEY_PARENT_RESOURCE_ID = "foreign_key_parent_resource_id";
//
//    private static final long serialVersionUID = 6566868621910913526L;
//
//    @Column(name = "resource_name", nullable = false, length = 100, columnDefinition = "VARCHAR(100) COMMENT '资源名称'")
//    private String resourceName;
//
//    @Column(name = "resource_code", nullable = false, length = 100, columnDefinition = "VARCHAR(100) COMMENT '资源唯一名称'")
//    private String resourceCode;
//
//    @Column(length = 100, columnDefinition = "COMMENT '资源URL'")
//    private String url;
//
//    @Column(length = 100, columnDefinition = "COMMENT '资源请求方式'")
//    private HttpMethod method;
//
//    @Column(nullable = false, columnDefinition = "INT(1) DEFAULT 0 COMMENT '菜单优先级'")
//    private Integer priority;
//
//    @Column(columnDefinition = "INT(1) DEFAULT 0 COMMENT '组织架构编码'")
//    private Boolean open;
//
//    @Column(columnDefinition = "INT(1) DEFAULT 0 COMMENT '组织架构层级关系'")
//    private Integer level;
//
//    @Column(columnDefinition = "VARCHAR(100) COMMENT 'ICON 的路径'")
//    private String icon;
//
//    @Column(name = FOREIGN_KEY_PARENT_RESOURCE_ID, insertable = false, updatable = false, columnDefinition = "BIGINT COMMENT '父资源的ID'")
//    private Long foreignKeyParentResourceId;
//
//    @ManyToOne(targetEntity = SystemResourceDO.class, cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
//    @JoinColumn(name = FOREIGN_KEY_PARENT_RESOURCE_ID, referencedColumnName = ID)
//    @JsonManagedReference
//    private SystemResourceDO parentResource;
//
//    @OrderBy("priority ASC")
//    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "parentResource")
//    @JsonBackReference
//    private Set<SystemResourceDO> childResources;
//
////    @ManyToMany(mappedBy = "systemResources", fetch = FetchType.LAZY)
////    @JsonBackReference
////    private Set<SystemRoleDO> systemRoles;
//
//}
