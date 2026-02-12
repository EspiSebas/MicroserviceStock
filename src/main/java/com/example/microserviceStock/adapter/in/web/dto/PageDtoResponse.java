package com.example.microserviceStock.adapter.in.web.dto;

import java.util.List;

public record PageDtoResponse<T>(
        List<T> content,
        int page,
        int size,
        long totalElements,
        int totalPages,
        boolean last
) {}
