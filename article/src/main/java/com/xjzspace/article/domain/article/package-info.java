package com.xjzspace.article.domain.article;
// 文章聚合，article是聚合根
// 由于逻辑简单，所以对于domain没有再分，而是将article的增删改逻辑全放在了聚合根里
// 如果业务逻辑复杂，可以考虑把其分为Article/ArticleFactory/ArticleService/ValueObject