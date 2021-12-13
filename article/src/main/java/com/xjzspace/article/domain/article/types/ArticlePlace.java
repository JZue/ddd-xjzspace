package com.xjzspace.article.domain.article.types;

@com.xjzspace.core.annotation.ValueObject
public enum ArticlePlace {

    /**
     * 0-列表页-博文列表
     * 1-精选页-浏览量高的-点击排行
     * 2-轮播图页-首页轮播图
     * 3-置顶页-站长推荐
     * 4-轮播右边的两篇
     **/
    LIST_PAGE,GOOD_PAGE,CAROUSEL_PAGE,TOP_PAGE,HEAD_LINE;


}
