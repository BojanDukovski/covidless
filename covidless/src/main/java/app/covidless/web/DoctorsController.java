package app.covidless.web;

import app.covidless.model.Role;
import app.covidless.service.AppUserService;
import app.covidless.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoctorsController {
    private final AppUserService appUserService;
    private final PostService postService;

    public DoctorsController(AppUserService appUserService, PostService postService) {
        this.appUserService = appUserService;
        this.postService = postService;
    }

    @GetMapping("/doctors")
    public String index(Model model){
        model.addAttribute("posts", this.postService.findAllByUserRole(Role.DOCTOR));
        return "doctors";
    }
}
