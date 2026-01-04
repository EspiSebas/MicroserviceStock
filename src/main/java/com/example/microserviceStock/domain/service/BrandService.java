package com.example.microserviceStock.domain.service;

import com.example.microserviceStock.domain.model.Brand;
import com.example.microserviceStock.domain.port.in.CreateBrandUseCase;
import com.example.microserviceStock.domain.port.out.BrandRepository;

import java.util.List;

public class BrandService implements CreateBrandUseCase {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand createBrand(String name, String description) {
        Brand brand = new Brand(name,description);
        return brandRepository.saveBrand(brand);
    }

    @Override
    public List<Brand> getAllBrand() {
        return brandRepository.getAllBrand();
    }
}
