package com.example.microserviceStock.domain.port.out;

import com.example.microserviceStock.domain.model.Article;

import java.util.List;

public interface ArticleRepository {
    Article saveArticle(Article article);
    List<Article> getAllArticles();

}
