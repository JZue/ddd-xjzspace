package com.xjzspace.article.domain.series.types;

import com.xjzspace.core.annotation.ValueObject;

@ValueObject
public enum ItemType {
    /**
     * 0 目录结点   1-文章结点（叶子结点）
     */
    DIR,ARTICLE;
}
