package com.example.microserviceStock.domain.port.in;

import com.example.microserviceStock.adapter.in.web.dto.ArticleRequest;
import com.example.microserviceStock.domain.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface CreateArticleUseCase {

    Article createArticle(String name, String description, int quantity, BigDecimal price, Set<Long> categories, Long brand);
    Page<Article> getAllArticles(Pageable pageable);

    void createArticle(ArticleRequest articleRequest);
}
