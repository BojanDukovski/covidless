package app.covidless.web;

import app.covidless.model.AppUser;
import app.covidless.model.Post;
import app.covidless.model.Role;
import app.covidless.service.AppUserService;
import app.covidless.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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
    public String index(Model model) {
        model.addAttribute("posts", this.postService.findAllByUserRole(Role.USER));
        return "forum";
    }

    @GetMapping("/forum")
    public String forum (Model model) {
        List<Post> posts = this.postService.findAllByUserRole(Role.USER);
        model.addAttribute("posts", posts);
        return "forum";
    }

    @GetMapping("/addPost")
    public String addPost() {
        return "form";
    }

    @PostMapping("/savePost")
    public String savePost(@RequestParam String content,
                           @RequestParam String keywords,
                           HttpServletRequest request) {
        AppUser user = this.appUserService.findByUsername(request.getRemoteUser());
        this.postService.save(keywords, content, 0.00, user);
        return "redirect:/forum";
    }

    @PostMapping("/searchPosts")
    public String search(@RequestParam String keyword, Model model) {
        List<Post> posts = this.postService.findAllByKeywordsContaining(keyword);
        model.addAttribute("posts", posts);
        return "forum";
    }
}
