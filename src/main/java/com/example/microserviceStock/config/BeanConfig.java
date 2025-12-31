package com.example.microserviceStock.config;

import com.example.microserviceStock.domain.port.in.CreateCategoryUseCase;
import com.example.microserviceStock.domain.port.out.CategoryRepository;
import com.example.microserviceStock.domain.service.CreateCategoryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CreateCategoryUseCase createCategoryUseCase(CategoryRepository categoryRepository){
        return new CreateCategoryService(categoryRepository);
    }
}
