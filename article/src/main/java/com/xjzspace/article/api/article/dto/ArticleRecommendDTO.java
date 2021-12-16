package com.xjzspace.article.api.article.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleRecommendDTO {
    private String articleUrl;
    private String articleTitle;

}
