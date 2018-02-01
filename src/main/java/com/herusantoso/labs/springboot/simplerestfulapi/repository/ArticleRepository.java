package com.herusantoso.labs.springboot.simplerestfulapi.repository;

import com.herusantoso.labs.springboot.simplerestfulapi.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
