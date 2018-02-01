package com.herusantoso.labs.springboot.simplerestfulapi.controller;


import com.herusantoso.labs.springboot.simplerestfulapi.model.Article;
import com.herusantoso.labs.springboot.simplerestfulapi.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    //Get all Articles
    @GetMapping("/articles")
    public List<Article> getAllArticles(){
        return articleRepository.findAll();
    }


    //Create a new article
    @PostMapping("/articles")
    public Article createArticle(@Valid @RequestBody Article article){
        return articleRepository.save(article);
    }


    // Get a single article
    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable(value = "id") Long articleId) {
        Article article = articleRepository.findOne(articleId);
        if(article == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(article);
    }

    // Update a article
    @PutMapping("/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable(value = "id") Long articleId,
                                           @Valid @RequestBody Article articleDetails) {
        Article article = articleRepository.findOne(articleId);
        if(article == null) {
            return ResponseEntity.notFound().build();
        }
        article.setTitle(articleDetails.getTitle());
        article.setContent(articleDetails.getContent());

        Article updatedArticle = articleRepository.save(article);
        return ResponseEntity.ok(updatedArticle);
    }

    // Delete a article
    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Article> deleteArticle(@PathVariable(value = "id") Long articleId) {
        Article article = articleRepository.findOne(articleId);
        if(article == null) {
            return ResponseEntity.notFound().build();
        }

        articleRepository.delete(article);
        return ResponseEntity.ok().build();
    }


}
