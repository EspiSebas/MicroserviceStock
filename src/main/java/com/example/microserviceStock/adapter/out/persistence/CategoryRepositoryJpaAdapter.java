package com.example.microserviceStock.adapter.out.persistence;

import com.example.microserviceStock.domain.model.Category;
import com.example.microserviceStock.domain.port.out.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository

public class CategoryRepositoryJpaAdapter implements CategoryRepository {
    private final JpaCategoryRepository jpaCategoryRepository;

    public CategoryRepositoryJpaAdapter(JpaCategoryRepository jpaCategoryRepository) {
        this.jpaCategoryRepository = jpaCategoryRepository;

    }


    @Override
    public Category saveCategory(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(category.getName());
        categoryEntity.setDescription(category.getDescription());

        CategoryEntity saved = jpaCategoryRepository.save(categoryEntity);
        return new Category(
                saved.getName(),
                saved.getDescription()
        );
    }
}