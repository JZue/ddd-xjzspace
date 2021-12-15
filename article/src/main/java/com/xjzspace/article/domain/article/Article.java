package com.xjzspace.article.domain.article;

import com.xjzspace.article.domain.article.types.*;
import com.xjzspace.article.domain.comment.Comment;
import com.xjzspace.core.IAggregateRoot;
import com.xjzspace.core.annotation.AggregateRoot;
import lombok.Builder;

import java.util.Date;
import java.util.List;

@AggregateRoot
@Builder
public class Article implements IAggregateRoot<Long> {

    private Long articleId;

    @Override
    public Long getIdentity() {
        return this.articleId;
    }

    /**
     * 标题
     **/
    private String articleTitle;

    /**
     * page路径
     **/
    private String articleUrl;

    /**
     * page状态:0-已发布,1-草稿,2-回收站
     **/
    private ArticleStatus articleStatus;

    /**
     * page访问量
     **/
    private Long articleViews;

    /**
     * 点赞数
     **/
    private Long articleThumbsUp;

    /**
     * 评论数量
     **/
    private Long commentNum;

    /**
     * 文章来源：0-原创，1-转载，2-学习笔记,3-系列文章
     **/
    private ArticleSource articleSource;

    /**
     * 文章访问权限-秘钥（ 密码==》秘钥  或者 权限==》秘钥 ）
     **/
    private ArticleSecret articleSecret;

    private ArticlePlace place;

    /**
     * 文章摘要
     **/
    private String articleSummary;

    /**
     * 文章内容
     **/
    private String md;

    /**
     * 分类code
     **/
    private ArticleCategory articleCategory;

    /**
     * 标签code
     **/
    private List<ArticleTag> articleTagList;

    private List<Comment> commentList;

    private Date createDate;

    private Date updateDate;


    public void auditById(Long articleId, int flag) {

    }


}
