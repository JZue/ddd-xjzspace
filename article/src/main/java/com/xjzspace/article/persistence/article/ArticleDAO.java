package com.xjzspace.article.persistence.article;

import com.xjzspace.article.api.article.dto.ArticleDetailDTO;
import com.xjzspace.article.api.article.dto.ArticleRecommendDTO;
import com.xjzspace.article.api.article.dto.ArticleTimeAxisDTO;
import com.xjzspace.article.persistence.article.dataobject.ArticleDO;
import com.xjzspace.article.persistence.article.dataobject.CategoryDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author: junzexue
 * @Date: 2019/6/20 上午11:37
 * @Description:
 **/
public interface ArticleDAO extends JpaRepository<ArticleDO,Long>, JpaSpecificationExecutor<ArticleDO> {
    /**
     * 根据web页的位置和文章的状态查询
     **/
    @Query(" select new com.xjzspace.article.api.article.dto.ArticleRecommendDTO(a.articleUrl,a.articleTitle) from ArticleDO a where  a.place=:place and a.articleStatus=:status")
    List<ArticleRecommendDTO> findByPlaceAndArticleStatus(@Param("place") Integer place, @Param("status") Integer articleStatus);

    ArticleDO findByArticleUrl(String articleUrl);
    @Query("select new com.xjzspace.article.api.article.dto.ArticleDetailDTO(a.articleSummary,a.createDate,a.id,a.articleTitle,a.articleUrl,a.articleViews,a.articleThumbsUp," +
            "a.commentNum,a.articleSource,a.articleSecretKey,a.place,c.categoryName,c.categoryCode,c.categoryDesc," +
            "c.levelCode,a.md) from ArticleDO a,CategoryDO c where a.categoryCode=c.categoryCode and a.articleUrl=:articleUrl and a.articleStatus=0")
    ArticleDetailDTO getDetailByArticleUrl(@Param("articleUrl") String articleUrl);

    @Query("select new com.xjzspace.article.api.article.dto.ArticleTimeAxisDTO(a.articleTitle,a.articleUrl,a.createDate) from ArticleDO a where a.articleStatus=0 order by a.createDate desc ")
    List<ArticleTimeAxisDTO> getArticleTimeAxis();

    @Query("select new com.xjzspace.article.api.article.dto.ArticleTimeAxisDTO(a.articleTitle,a.articleUrl,a.createDate) from ArticleDO a where a.articleTitle like ?1 and a.articleStatus = 0 ")
    List<ArticleTimeAxisDTO> getArticleTimeAxisByKey(String key);

    @Modifying
    @Query("update ArticleDO a set a.articleThumbsUp=a.articleThumbsUp+1 where a.id =:articleId")
    Integer increArticleThumbsUp(@Param("articleId") Long articleId);


    @Modifying
    @Query("update ArticleDO a set a.articleViews=a.articleViews+:offset where a.id =:articleId")
    Integer increPageViewCount(@Param("articleId") Long articleId,@Param("offset") Long offset);

    @Modifying
    @Query("update ArticleDO a set a.commentNum=a.commentNum+1 where a.id =:articleId")
    Integer increCommentNum(@Param("articleId") Long articleId);

    @Query("select a.id from ArticleDO a where a.articleTitle like ?1")
    List<Long> getIdsByArticleTitle(String titleKey);

    @Modifying
    @Query(value = "update ArticleDO a set a.articleStatus=:flag where a.id=:id")
    Integer auditById(@Param("id")Long id,@Param("flag")Integer flag);


    @Query(value = "select *  from article  a where a.id<?1 and a.article_status = 0 order by a.create_date desc limit 1",nativeQuery = true)
    ArticleDO getPreArticle(@Param("articleId") Long articleId);

    @Query(value = "select * from article  a where a.id>?1 and a.article_status = 0 order by a.create_date asc limit 1",nativeQuery = true)
    ArticleDO getNextArticle(@Param("articleId")Long articleId);

    @Query(value = "select * from article a where a.article_status=0 and a.del_flag=0 order by  a.article_views desc limit 10",nativeQuery = true)
    List<ArticleDO> getRecommondArticleOrderByPageViews();

    ArticleDO findByIdAndArticleStatus(Long id,Integer articleStatus);

}