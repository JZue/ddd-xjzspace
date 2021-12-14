package com.xjzspace.article.domain.comment;

import com.xjzspace.article.domain.comment.types.CommentType;
import com.xjzspace.core.IAggregateRoot;
import com.xjzspace.core.annotation.AggregateRoot;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@AggregateRoot
public class Comment implements IAggregateRoot<Long> {

    private Long commentId;

    /**
     * 来源ID
     **/
    private Long sourceId;

    /**
     * 来源：目前主要有文章评论和网站留言
     **/
    private CommentType sourceType;

    /**
     * 评论人昵称
     */
    private String commentAuthor;

    /**
     * 评论人的邮箱
     */
    @Email(message = "邮箱格式不正确")
    private String commentAuthorEmail;

    @NotBlank(message = "评论用内容不能为空")
    private String commentContent;

    /**
     * 评论人的主页
     */
    private String commentAuthorSite;

    /**
     * 评论人的ip
     */
    private String commentAuthorIp;

    /**
     * 评论者头像
     */
    private String  commentAvatar;

    /**
     * 0-未审核评论(可展示、但是后续要审核)1-已审核评论2-审核失败评论
     **/
    private Integer commentStatus;

    /**
     * uid为null标识是匿名，开源版本下到了登陆功能，所以一定为null
     **/
    private String uid;

    /**
     * 点赞数
     **/
    private Integer starCount;

    /**
     * user-agent
     **/
    private String UA;

    /**
     * 所回复的评论
     * 若此条评论是回复他人评论则为被回复评论
     * 若不是回复别人的评论，这默认为null
     **/
    private Comment pComment;

    /**
     * 当前评论下的所有子评论
     */
    private List<Comment> childComments;

    private Date createDate;

    private Date updateDate;

    @Override
    public Long getIdentity() {
        return this.commentId;
    }
}
