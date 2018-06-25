package pro.xway.restexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pro.xway.restexample.model.Article;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
public class Api {
    @Autowired
    private MainController mainController;

    @PostMapping(path = "/api/addArticle")
    public Article addArticle(@RequestBody Article article){
        if (article.getId() != 0 || article.getName() != null)
            mainController.getArticles().add(article);
        return article;
    }

    @GetMapping("/api/getArticles")
    public List<Article> getArticle(){
        return mainController.getArticles();
    }

    @PostMapping (path = "/api/removeArticle")
    public boolean removeArticle(@RequestBody long id) {
        List<Article> list = mainController.getArticles().stream()
                .filter(article1 -> article1.getId() != id)
                .collect(Collectors.toList());
        mainController.setArticles(list);
        return true;
    }


}
