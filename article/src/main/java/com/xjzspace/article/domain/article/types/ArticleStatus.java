package com.xjzspace.article.domain.article.types;

public enum ArticleStatus implements ValueObject<String> {

    /**
     * page状态:0-已发布,1-草稿,2-回收站
     **/
    PUBLISHED,DRAFT,GARBAGE;


    @Override
    public String v() {
        return this.name();
    }
}
