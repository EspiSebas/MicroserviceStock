package com.example.microserviceStock.adapter.out.persistence;

import com.example.microserviceStock.domain.model.Article;
import com.example.microserviceStock.domain.port.out.ArticleRepository;
import org.springframework.stereotype.Repository;

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

        Set<CategoryEntity> categoriesEntitySet = article.getCategories().stream()
                .map(jpaCategoryRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());

        BrandEntity getBrand = jpaBrandRepository.findById(article.getBrand()).orElseThrow();
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setName(article.getName());
        articleEntity.setDescription(article.getDescription());
        articleEntity.setQuantity(article.getQuantity());
        articleEntity.setPrice(article.getPrice());
        articleEntity.setCategories(categoriesEntitySet);
        articleEntity.setPrice(article.getPrice());
        articleEntity.setBrand(getBrand);

        ArticleEntity saved = jpaArticleRepository.save(articleEntity);

        return new Article(
                saved.getName(),
                saved.getDescription(),
                saved.getQuantity(),
                saved.getPrice(),
                saved.getCategories(),
                saved.getBrand()
        );


    }

    @Override
    public List<Article> getAllArticles() {
        return jpaArticleRepository.findAll()
                .stream()
                .map(p-> new Article(
                        p.getName(),
                        p.getDescription(),
                        p.getQuantity(),
                        p.getPrice(),
                        p.getCategories()
                                .stream()
                                .map(CategoryEntity::getId)
                                .collect(Collectors.toSet()),
                        p.getBrand().getId()
                ))
                .toList();
    }


}
