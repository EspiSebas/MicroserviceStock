package com.example.microserviceStock.domain.port.out;

import com.example.microserviceStock.adapter.in.web.dto.ArticleDto;
import com.example.microserviceStock.domain.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleRepository {
    Article saveArticle(Article article);
    Page<Article> getAllArticles(Pageable pageable);

}
