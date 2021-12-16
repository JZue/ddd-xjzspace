package com.xjzspace.core;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public class BaseV2DO {
    private static final long serialVersionUID = 1L;
    /**
     * 主键ID自动生成策略
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 36)
    protected Long id;
}
