package com.std.sbb1124test.article;

import java.time.LocalDateTime;
import java.util.List;

import com.std.sbb1124test.answer.Answer;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "article", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
}
