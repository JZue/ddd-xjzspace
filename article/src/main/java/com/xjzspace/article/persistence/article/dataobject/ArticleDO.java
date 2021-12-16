package com.xjzspace.article.persistence.article.dataobject;

import com.xjzspace.core.BaseV1DO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author junzexue
 * @date 2019/6/22 上午9:39
 *
 **/
@Getter
@Setter
@ToString
@Table(name = "article")
@Where(clause = "del_flag=0")
@Entity
public class ArticleDO extends BaseV1DO<String> implements Serializable {

    private static final long serialVersionUID = 2383678847517271505L;

    /**
     * 用户ID
     **/
    private Long userId;
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
    private Integer articleStatus;

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
    private Integer articleSource;


    /**
     * 文章访问权限-秘钥（ 密码==》秘钥  或者 权限==》秘钥 ）
     **/
    private String articleSecretKey;

    /**
     * 0-列表页-博文列表
     * 1-精选页-浏览量高的-点击排行
     * 2-轮播图页-首页轮播图
     * 3-置顶页-站长推荐
     * 4-轮播右边的两篇
     **/
    private Integer place;

    /**
     * 分类code
     **/
    private String categoryCode;

    private String articleSummary;

    private String md;

}
