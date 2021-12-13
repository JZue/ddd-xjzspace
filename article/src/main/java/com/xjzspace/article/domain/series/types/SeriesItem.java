package com.xjzspace.article.domain.series.types;

import com.xjzspace.article.domain.article.Article;
import com.xjzspace.core.annotation.AggregateRoot;
import com.xjzspace.core.annotation.ValueObject;

import java.util.Date;

@ValueObject
public class SeriesItem {

    private Article article;

    /**
     * 系列父id
     */
    private Long parentId;

    /**
     * 层级1-2-3
     */
    private Integer level;

    /**
     * item的标题，一般就是文章标题
     */
    private String itemTitle;

    /**
     * item的跳转链接，并非文章的跳转链接
     */
    private String itemPageUrl;


    private ItemType status;

    private Long itemId;

    private Date createDate;

    private Date updateDate;

}
