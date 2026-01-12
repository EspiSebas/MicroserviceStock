package com.example.microserviceStock.adapter.out.persistence;

import com.example.microserviceStock.adapter.in.web.dto.ArticleDto;
import com.example.microserviceStock.domain.model.Article;
import com.example.microserviceStock.domain.model.Brand;
import com.example.microserviceStock.domain.port.out.ArticleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class ArticleRepositoryJpaAdapter implements ArticleRepository {

    private final JpaArticleRepository jpaArticleRepository;
    private final JpaBrandRepository jpaBrandRepository;
    private final JpaCategoryRepository jpaCategoryRepository;

    public ArticleRepositoryJpaAdapter(JpaArticleRepository jpaArticleRepository, JpaBrandRepository jpaBrandRepository, JpaCategoryRepository jpaCategoryRepository) {
        this.jpaArticleRepository = jpaArticleRepository;
        this.jpaBrandRepository = jpaBrandRepository;
        this.jpaCategoryRepository = jpaCategoryRepository;
    }

    @Override
    public Article saveArticle(Article article) {

        Set<CategoryEntity> categoriesEntitySet =
                new HashSet<>(jpaCategoryRepository.findAllById(article.getCategories()));

        if (categoriesEntitySet.isEmpty()) {
            throw new RuntimeException("Categories not found");
        }

        BrandEntity getBrand = jpaBrandRepository.findById(article.getBrand()).orElseThrow(() -> new RuntimeException("Brand not found"));
        ArticleEntity articleEntity = new ArticleEntity();

        articleEntity.setName(article.getName());
        articleEntity.setDescription(article.getDescription());
        articleEntity.setQuantity(article.getQuantity());
        articleEntity.setPrice(article.getPrice());
        articleEntity.setCategories(categoriesEntitySet);
        articleEntity.setPrice(article.getPrice());
        articleEntity.setBrand(getBrand);

        ArticleEntity saved = jpaArticleRepository.save(articleEntity);

        return new  Article(
                saved.getName(),
                saved.getDescription(),
                saved.getQuantity(),
                saved.getPrice(),
                saved.getBrand().getId(),
                saved.getCategories()
                        .stream()
                        .map(CategoryEntity::getId)
                        .collect(Collectors.toSet())
        );


    }

    @Override
    public Page<Article> getAllArticles(Pageable pageable) {
        return jpaArticleRepository.findAll(pageable)
                .map(p-> new Article(
                        p.getName(),
                        p.getDescription(),
                        p.getQuantity(),
                        p.getPrice(),
                        p.getBrand().getId(),
                        p.getCategories()
                                .stream()
                                .map(CategoryEntity::getId)
                                .collect(Collectors.toSet())

                ));

    }


}
