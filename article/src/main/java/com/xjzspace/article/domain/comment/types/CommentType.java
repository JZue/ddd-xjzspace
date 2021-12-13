package com.xjzspace.article.domain.comment.types;

import com.xjzspace.core.annotation.ValueObject;

@ValueObject
public enum CommentType {
    /**
     * 文章评论、网站留言
     */
    ARTICLE_COMMENT,WEB_MESSAGE;
}
