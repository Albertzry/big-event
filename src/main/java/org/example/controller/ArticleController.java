package org.example.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.example.pojo.Article;
import org.example.pojo.Result;
import org.example.service.ArticleService;
import org.example.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PutMapping
    public Result add(@RequestBody Article article){
        articleService.add(article);
        return Result.success();
    }
}
