package com.example.microserviceStock.adapter.in.web;

import com.example.microserviceStock.adapter.in.web.dto.ArticleRequest;
import com.example.microserviceStock.domain.model.Article;
import com.example.microserviceStock.domain.model.Brand;
import com.example.microserviceStock.domain.port.in.CreateArticleUseCase;
import org.apache.coyote.Response;
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
    public ResponseEntity<List<Article>> getAllBrand(){
        return ResponseEntity.ok(createArticleUseCase.getAllArticles());
    }
}
