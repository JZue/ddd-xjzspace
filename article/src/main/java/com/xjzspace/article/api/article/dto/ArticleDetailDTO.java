package com.xjzspace.article.api.article.dto;

import com.xjzspace.article.persistence.article.dataobject.TagDO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author junzexue
 * @date 2019/6/22 下午5:26
 * @description
 **/
@Data
@ToString
@NoArgsConstructor
public class ArticleDetailDTO {

    private Long id;
    /**
     * 标题
     **/
    private String articleTitle;

    /**
     * page路径
     **/
    private String articleUrl;
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
     * 文章来源：0-原创，1-转载，2-翻译 3-系列
     **/
    private Integer articleSource;

    /**
     * 是否允许评论:0-禁止，1-允许
     **/
    private Integer allowDiscuss;

    private Date createDate;
    /**
     * 文章访问权限-秘钥（ 密码==》秘钥  或者 权限==》秘钥 ）
     **/
    private String articleSecretKey;

    /**
     * 文章显示区域:0-列表页 1-精选页  2-轮播图页  3-置顶页
     **/
    private Integer place;

    /**
     * 分类名称
     **/
    private String categoryName;


    /**
     * 分类code
     **/
    private String categoryCode;

    private List<String> categoryLevelCode;

    /**
     * 分类描述
     **/
    private String categoryDesc;

    private List<TagDO> articleTagList;

    private String  md;

    private String html;

    private String articleSummary;

    public ArticleDetailDTO(String articleSummary, Date createDate, Long id, String articleTitle, String articleUrl,
                            Long articleViews, Long articleThumbsUp,
                            Long commentNum, Integer articleSource, String articleSecretKey,
                            Integer place, String categoryName, String categoryCode,
                            String categoryDesc, String levelCode, String md) {
        this.articleSummary=articleSummary;
        this.createDate=createDate;
        this.id=id;
        this.articleTitle = articleTitle;
        this.articleUrl = articleUrl;
        this.articleViews = articleViews;
        this.articleThumbsUp = articleThumbsUp;
        this.commentNum = commentNum;
        this.articleSource = articleSource;
        this.articleSecretKey = articleSecretKey;
        this.place = place;
        this.categoryName = categoryName;
        this.categoryCode = categoryCode;
        this.categoryDesc = categoryDesc;
        this.categoryLevelCode= Arrays.asList(levelCode.split("/"));
        this.md = md;
    }
}