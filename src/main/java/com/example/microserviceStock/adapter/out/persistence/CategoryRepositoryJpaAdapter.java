package com.example.microserviceStock.adapter.out.persistence;

import com.example.microserviceStock.domain.exception.NameException;
import com.example.microserviceStock.domain.model.Category;
import com.example.microserviceStock.domain.port.out.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class CategoryRepositoryJpaAdapter implements CategoryRepository {
    private final JpaCategoryRepository jpaCategoryRepository;

    public CategoryRepositoryJpaAdapter(JpaCategoryRepository jpaCategoryRepository) {
        this.jpaCategoryRepository = jpaCategoryRepository;

    }


    @Override
    public Category saveCategory(Category category) {
        if(jpaCategoryRepository.findByName(category.getName()).isPresent()){
            throw new NameException("The name is repited");

        };
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(category.getName());
        categoryEntity.setDescription(category.getDescription());

        CategoryEntity saved = jpaCategoryRepository.save(categoryEntity);
        return new Category(
                saved.getName(),
                saved.getDescription()
        );
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return jpaCategoryRepository.findAll(pageable)
                .map(p -> new Category(

                        p.getName(),
                        p.getDescription()

                ));
    }


}