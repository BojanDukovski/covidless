package app.covidless.web;

import app.covidless.model.AppUser;
import app.covidless.model.Post;
import app.covidless.model.Role;
import app.covidless.service.AppUserService;
import app.covidless.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
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
    public String index(Model model, HttpServletRequest request) {
        AppUser user = this.appUserService.findByUsername(request.getRemoteUser());
        if (user == null) {
            return "login";
        }
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

    @Transactional
    @PostMapping("/rating")
    public String rating(@RequestParam String postId, String chosenRating) {
        Integer cr = Integer.valueOf(chosenRating);
        Post post = this.postService.findById(Long.valueOf(postId));
        Double oldRating = post.getRating();
        Double newRating = null;
        if (cr == 0) {
            newRating = oldRating;
        } else if (cr < 0) {
            newRating = oldRating - 0.2*Math.abs(cr);
        } else if (cr > 0) {
            newRating = oldRating + 0.2*Math.abs(cr);
        }
        post.setRating(newRating);
        if (newRating <= 0) {
            this.postService.deleteById(post.getId());
            return "redirect:/forum";
        }
        if (newRating >= 5.00) newRating = 5.00;
        this.postService.deleteById(Long.valueOf(postId));
        this.postService.save(post.getKeywords(), post.getContent(), post.getRating(), post.getUser());
        return "redirect:/forum";
    }
}
