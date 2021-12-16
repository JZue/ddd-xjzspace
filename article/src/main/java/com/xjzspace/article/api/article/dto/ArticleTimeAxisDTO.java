package com.xjzspace.article.api.article.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class ArticleTimeAxisDTO {
    private String articleTitle;
    private String articleUrl;
    private Date createDate;

    public ArticleTimeAxisDTO(String articleTitle, String articleUrl, Date createDate) {
        this.articleTitle = articleTitle;
        this.articleUrl = articleUrl;
        this.createDate = createDate;
    }
}