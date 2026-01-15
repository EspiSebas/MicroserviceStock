package com.example.microserviceStock.adapter.out.persistence;

import com.example.microserviceStock.domain.model.Article;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "brands")
public class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;
    private String description;
    @OneToMany(mappedBy = "brand")
    private Set<ArticleEntity> articles = new HashSet<>();

    public BrandEntity(Long id, String name, String description, Set<ArticleEntity> articles) {
        Id = id;
        this.name = name;
        this.description = description;
        this.articles = articles;
    }

    public BrandEntity() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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
