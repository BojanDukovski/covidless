package app.covidless.config;

import app.covidless.model.AppUser;
import app.covidless.model.Post;
import app.covidless.model.Role;
import app.covidless.repository.AppUserRepository;
import app.covidless.repository.PostRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Component
public class DataInitializer {

    private final AppUserRepository appUserRepository;
    private final PostRepository postRepository;

    public DataInitializer(AppUserRepository appUserRepository, PostRepository postRepository) {
        this.appUserRepository = appUserRepository;
        this.postRepository = postRepository;
    }

    @PostConstruct
    @Transactional
    public void initData(){
        AppUser user1 = new AppUser("admin", "admin", "Bojan", "Dukovski", "biography...", "070123456", Role.ADMIN, null);
        AppUser user2 = new AppUser("viktor.meglenovski", "vm", "Viktor", "Meglenovski", "biography...", "070123456", Role.USER, null);
        AppUser user3 = new AppUser("hristina.krstevska","hk","Hristina", "Krstevska", "biography...", "070123456", Role.DOCTOR, null);
        Post post1 = new Post("a,b,c", "Content....", 4.22, user1);
        Post post2 = new Post("a,b,c", "Content....", 1.22, user2);
        Post post3 = new Post("a,b,c", "Content....", 0.22, user3);

        this.appUserRepository.save(user1);
        this.appUserRepository.save(user2);
        this.appUserRepository.save(user3);

        this.postRepository.save(post1);
        this.postRepository.save(post2);
        this.postRepository.save(post3);
    }
}
