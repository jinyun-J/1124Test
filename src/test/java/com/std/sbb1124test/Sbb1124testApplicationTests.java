package com.std.sbb1124test;

import com.std.sbb1124test.article.Article;
import com.std.sbb1124test.article.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class Sbb1124testApplicationTests {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void testJpa() {
        Article article = new Article();
        article.setSubject("첫번째 게시글입니다");
        article.setContent("게시글 내용입니다");
        article.setCreateDate(LocalDateTime.now());
        this.articleRepository.save(article);
    }
}
