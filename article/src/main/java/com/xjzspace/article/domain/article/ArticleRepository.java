package com.xjzspace.article.domain.article;

public interface ArticleRepository {

    Article save(Article article);

    void incrArticleViews(Long articleId);

    void incrArticleThumbsUp(Long articleId, String ip);

    void deleteById(Long id);

}
