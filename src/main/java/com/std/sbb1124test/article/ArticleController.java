package com.std.sbb1124test.article;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/article")
@RequiredArgsConstructor
@Controller
public class ArticleController {

    private  final ArticleService articleService;
    private  final ArticleRepository articleRepository;
    @GetMapping("/list")
    public String list(Model model) {
        List<Article> articleList = this.articleService.getList();
        model.addAttribute("articleList", articleList);
        return "article_list";
    }
    @GetMapping(value = "detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        Article article = this.articleService.getArticle(id);
        model.addAttribute("article", article);
        return "article_detail";
    }
    @GetMapping("/create")
    public String articleCreate() {
        return "article_form";
    }

    @PostMapping("/create")
    public String questionCreate(@Valid ArticleForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "article_form";
        }
        this.articleService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/article/list";
    }
}
