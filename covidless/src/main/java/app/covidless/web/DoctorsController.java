package app.covidless.web;

import app.covidless.model.AppUser;
import app.covidless.model.Role;
import app.covidless.service.AppUserService;
import app.covidless.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DoctorsController {
    private final AppUserService appUserService;
    private final PostService postService;

    public DoctorsController(AppUserService appUserService, PostService postService) {
        this.appUserService = appUserService;
        this.postService = postService;
    }

    @GetMapping("/doctors")
    public String index(Model model, HttpServletRequest request){
        model.addAttribute("posts", this.postService.findAllByUserRole(Role.DOCTOR));
        AppUser user = this.appUserService.findByUsername(request.getRemoteUser());
        model.addAttribute("user", user);
        return "doctors";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model){
        AppUser user = this.appUserService.findById(id);
        model.addAttribute("user", user);
        return "details";
    }
}
