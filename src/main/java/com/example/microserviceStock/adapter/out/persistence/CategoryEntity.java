package com.example.microserviceStock.adapter.out.persistence;


import com.example.microserviceStock.domain.model.Article;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<ArticleEntity> articles = new HashSet<>();

    public CategoryEntity(Long id, String name, String description, Set<ArticleEntity> articles) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.articles = articles;
    }

    public CategoryEntity() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ArticleEntity> getArticles() {
        return articles;
    }

    public void setArticles(Set<ArticleEntity> articles) {
        this.articles = articles;
    }
}
