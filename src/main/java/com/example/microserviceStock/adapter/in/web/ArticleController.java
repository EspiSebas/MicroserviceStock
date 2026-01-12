package com.example.microserviceStock.adapter.in.web;

import com.example.microserviceStock.adapter.in.web.dto.ArticleDto;
import com.example.microserviceStock.adapter.in.web.dto.ArticleRequest;
import com.example.microserviceStock.adapter.in.web.dto.PageDtoResponse;
import com.example.microserviceStock.domain.model.Article;
import com.example.microserviceStock.domain.model.Brand;
import com.example.microserviceStock.domain.port.in.CreateArticleUseCase;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("articles")
public class ArticleController {

    private final CreateArticleUseCase createArticleUseCase;


    public ArticleController(CreateArticleUseCase createArticleUseCase) {
        this.createArticleUseCase = createArticleUseCase;
    }

    @PostMapping("create")
    public ResponseEntity<ApiResponse> createArticle(@RequestBody ArticleRequest articleRequest){
        createArticleUseCase.createArticle(articleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("The article is successfully created !!",HttpStatus.CREATED.value()));
    }


    @GetMapping("all")
    public PageDtoResponse<Article> getAllArticle(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ){
        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page,size,sort);
        Page<Article> pageResult = createArticleUseCase.getAllArticles(pageable);
        return new PageDtoResponse<>(
                pageResult.getContent(),
                pageResult.getNumber(),
                pageResult.getSize(),
                pageResult.getTotalElements(),
                pageResult.getTotalPages(),
                pageResult.isLast()
        );
    }
}
