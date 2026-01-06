package com.example.microserviceStock.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaArticleRepository extends JpaRepository<ArticleEntity,Long> {
    Optional<ArticleEntity> findByName(String name);

}
