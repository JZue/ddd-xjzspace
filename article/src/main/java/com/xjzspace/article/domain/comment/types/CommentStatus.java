package com.xjzspace.article.domain.comment.types;

import com.xjzspace.core.annotation.ValueObject;

@ValueObject
public enum CommentStatus {
    /**
     * 0-未审核评论(可展示、但是后续要审核)1-已审核评论2-审核拒绝
     **/
    UN_AUDIT,AUDIT,REFUSE;
}
