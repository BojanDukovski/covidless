package app.covidless.web;

import app.covidless.model.Post;
import app.covidless.service.AppUserService;
import app.covidless.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PostController {

    public final AppUserService appUserService;
    private final PostService postService;

    public PostController(AppUserService appUserService, PostService postService) {
        this.appUserService = appUserService;
        this.postService = postService;
    }

    @GetMapping("/")
    public String index() {
        return "forum";
    }

    @GetMapping("/forum")
    public String forum (Model model) {
        List<Post> posts = this.postService.findAll();
        model.addAttribute("posts", posts);
        return "forum";
    }
}
