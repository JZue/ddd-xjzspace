package com.xjzspace.article.domain.article.types;

public enum ArticleSource implements ValueObject<String> {

    /**
     * ：0-原创
     */
    ORIGINAL,
    /**
     * 1-转载
     */
    REPRINT,
    /**
     * 2-学习笔记
     */
    NOTE,
    /**
     * ：3-系列文章
     */
    SERIES;

    @Override
    public String v() {
        return this.name();
    }
}
