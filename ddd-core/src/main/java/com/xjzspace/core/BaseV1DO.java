package com.xjzspace.core;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * javax.persistence.@Id和org.springframework.data.annotation.@Id区别
 * 前者主要是用于关系型数据库，后者主要用于非关系型数据库
 * @author junzexue
 * @date 2019/6/20 上午11:07
 **/
@MappedSuperclass
@EqualsAndHashCode(exclude = "id")
@Data
@EntityListeners(AuditingEntityListener.class)
public class BaseV1DO<U> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键ID自动生成策略
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 36)
    protected Long id;


    /**
     * 创建人 登录帐号
     */
    @CreatedBy
    @Column(name = "create_by",length = 36)
    protected U createBy;

    /**
     * 修改人 登录的帐号
     */
    @LastModifiedBy
    @Column(name = "update_by", length = 36)
    protected U updateBy;

    /**
     * 创建时间
     */
    @CreatedDate
    @Temporal(TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "create_date")
    protected Date createDate;
    /**
     * 修改时间
     */
    @LastModifiedDate
    @Temporal(TIMESTAMP)
    @Column(name = "update_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected Date updateDate;

    /**
     * 删除标志 0 - 正常 1 - 删除
     */
    @Column(name = "del_flag",columnDefinition = "int default 0")
    @JsonIgnore
    private int delFlag;

    /**
     * 版本号--乐观锁
     */
//    @Version
//    @Column(name = "version")
//    protected Integer version;
}