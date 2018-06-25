package pro.xway.restexample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pro.xway.restexample.model.Article;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class MainController {
    private List<Article> articles;

    @PostConstruct
    public void init(){
        articles = new ArrayList<>();
        articles.add(new Article(1, "Java"));
        articles.add(new Article(2, "PHP"));
        articles.add(new Article(3, "Ruby"));
    }
    @RequestMapping("/")
    public String getIndex(Model model){
        model.addAttribute("articles", articles);
        return "index";
    }


    public List<Article> getArticles() {
        return articles;
    }
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
