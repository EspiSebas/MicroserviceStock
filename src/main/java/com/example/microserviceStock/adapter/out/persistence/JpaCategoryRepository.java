package com.example.microserviceStock.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCategoryRepository extends JpaRepository<CategoryEntity,Long> {
}
