package com.example.microserviceStock.adapter.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ArticleDto {
    private Long id;
    private String name;
    private String description;
    private int quantity;
    private BigDecimal price;
    private BrandDto brand;
    private List<CategoryDto> categories;
}
