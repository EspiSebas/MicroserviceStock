package com.example.microserviceStock.domain.service;

import com.example.microserviceStock.adapter.in.web.dto.ArticleRequest;
import com.example.microserviceStock.domain.model.Article;
import com.example.microserviceStock.domain.port.in.CreateArticleUseCase;
import com.example.microserviceStock.domain.port.out.ArticleRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class ArticleService implements CreateArticleUseCase {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article createArticle(String name, String description, int quantity, BigDecimal price, Set<Long> categories, Long brand) {
        Article article = new Article(name, description,quantity,price,brand,categories);
        return articleRepository.saveArticle(article);

    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.getAllArticles();
    }

    @Override
    public void createArticle(ArticleRequest articleRequest) {
        Article article = new Article(
                articleRequest.getName(),
                articleRequest.getDescription(),
                articleRequest.getQuantity(),
                articleRequest.getPrice(),
                articleRequest.getIdBrand(),
                (Set<Long>) articleRequest.getCategoriesIds()

        );

        articleRepository.saveArticle(article);
    }
}
