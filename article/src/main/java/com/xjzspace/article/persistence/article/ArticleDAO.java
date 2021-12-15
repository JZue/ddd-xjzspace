package com.xjzspace.article.persistence.article;

import com.xjzspace.article.api.article.dto.ArticleRecommendDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author: junzexue
 * @Date: 2019/6/20 上午11:37
 * @Description:
 **/
public interface ArticleDAO extends JpaRepository<Article,Long>, JpaSpecificationExecutor<Article> {
    /**
     * 根据web页的位置和文章的状态查询
     **/
    @Query(" select new com.xjzspace.article.api.article.dto.ArticleRecommendDTO(a.articleUrl,a.articleTitle) from Article a where  a.place=:place and a.articleStatus=:status")
    List<ArticleRecommendDTO> findByPlaceAndArticleStatus(@Param("place") Integer place, @Param("status") Integer articleStatus);

    Article findByArticleUrl(String articleUrl);
    @Query("select new com.jzuekk.light.kkblog.model.vo.ArticleDetailVo(a.articleSummary,a.createDate,a.id,a.articleTitle,a.articleUrl,a.articleViews,a.articleThumbsUp," +
            "a.commentNum,a.articleSource,a.articleSecretKey,a.place,c.categoryName,c.categoryCode,c.categoryDesc," +
            "c.levelCode,a.md) from Article a,Category c where a.categoryCode=c.categoryCode and a.articleUrl=:articleUrl and a.articleStatus=0")
    ArticleDetailVo getDetailByArticleUrl(@Param("articleUrl") String articleUrl);

    @Query("select new com.jzuekk.light.kkblog.model.vo.ArticleTimeAxis(a.articleTitle,a.articleUrl,a.createDate) from Article a where a.articleStatus=0 order by a.createDate desc ")
    List<ArticleTimeAxis> getArticleTimeAxis();

    @Query("select new com.jzuekk.light.kkblog.model.vo.ArticleTimeAxis(a.articleTitle,a.articleUrl,a.createDate) from Article a where a.articleTitle like ?1 and a.articleStatus = 0 ")
    List<ArticleTimeAxis> getArticleTimeAxisByKey(String key);

    @Modifying
    @Query("update Article a set a.articleThumbsUp=a.articleThumbsUp+1 where a.id =:articleId")
    Integer increArticleThumbsUp(@Param("articleId") Long articleId);


    @Modifying
    @Query("update Article a set a.articleViews=a.articleViews+:offset where a.id =:articleId")
    Integer increPageViewCount(@Param("articleId") Long articleId,@Param("offset") Long offset);

    @Modifying
    @Query("update Article a set a.commentNum=a.commentNum+1 where a.id =:articleId")
    Integer increCommentNum(@Param("articleId") Long articleId);

    @Query("select a.id from Article a where a.articleTitle like ?1")
    List<Long> getIdsByArticleTitle(String titleKey);

    @Modifying
    @Query(value = "update Article a set a.articleStatus=:flag where a.id=:id")
    Integer auditById(@Param("id")Long id,@Param("flag")Integer flag);


    @Query(value = "select *  from article  a where a.id<?1 and a.article_status = 0 order by a.create_date desc limit 1",nativeQuery = true)
    Article getPreArticle(@Param("articleId") Long articleId);

    @Query(value = "select * from article  a where a.id>?1 and a.article_status = 0 order by a.create_date asc limit 1",nativeQuery = true)
    Article getNextArticle(@Param("articleId")Long articleId);

    @Query(value = "select * from article a where a.article_status=0 and a.del_flag=0 order by  a.article_views desc limit 10",nativeQuery = true)
    List<Article> getRecommondArticleOrderByPageViews();

    Article findByIdAndArticleStatus(Long id,Integer articleStatus);

}