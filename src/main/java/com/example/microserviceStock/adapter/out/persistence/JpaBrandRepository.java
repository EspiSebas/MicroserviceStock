package com.example.microserviceStock.adapter.out.persistence;

import com.example.microserviceStock.domain.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaBrandRepository extends JpaRepository<BrandEntity,Long> {
    Optional<BrandEntity> findByName(String name);
}
