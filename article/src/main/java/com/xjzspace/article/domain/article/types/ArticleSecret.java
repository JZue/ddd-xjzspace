package com.xjzspace.article.domain.article.types;

public class ArticleSecret implements ValueObject<String> {
    String secret;
    @Override
    public String v() {
        return secret;
    }
}
