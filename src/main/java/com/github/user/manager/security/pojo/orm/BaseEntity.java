package com.github.user.manager.security.pojo.orm;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.user.manager.security.pojo.converter.MobileMosaicConverter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.Date;


/**
 * @author 石少东
 * @date 2020-08-21 23:12
 * @since 1.0
 */

@Getter
@Setter
@MappedSuperclass
@EqualsAndHashCode(of = "id", callSuper = false)
public abstract class BaseEntity implements Serializable {

    protected static final String ID = "id";

    private static final long serialVersionUID = 6967867647425236119L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID)
    private Long id;

    @JsonIgnore
    @ColumnDefault("0")
    @Column(columnDefinition = "INT(1) COMMENT '是否为预置'")
    private Boolean preset;

    @JsonIgnore
    @ColumnDefault("1")
    @Column(columnDefinition = "INT(1) COMMENT '是否启用'")
    private Boolean enabled;

    @JsonIgnore
    @ColumnDefault("0")
    @Column(columnDefinition = "INT(1) COMMENT '改记录是否删除'")
    private Boolean deleted;

    @CreatedDate
    @Column(name = "create_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastModifiedDate;

    @CreatedBy
    @Column(name = "create_by")
    @Convert(converter = MobileMosaicConverter.class)
    private String createBy;

    @LastModifiedBy
    @Column(name = "last_modified_by")
    @Convert(converter = MobileMosaicConverter.class)
    private String lastModifiedBy;

    @Column(columnDefinition = "VARCHAR(255) COMMENT '备注'")
    private String note;

    @Version
    @Column(columnDefinition = "BIGINT COMMENT '版本号'")
    private Long version;

}
