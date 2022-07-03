package app.covidless.config;

import app.covidless.model.AppUser;
import app.covidless.model.Post;
import app.covidless.model.Role;
import app.covidless.repository.AppUserRepository;
import app.covidless.repository.PostRepository;
import app.covidless.service.AppUserService;
import app.covidless.service.PostService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Component
public class DataInitializer {
    private final PostService postService;
    private final AppUserService appUserService;

    public DataInitializer(PostService postService, AppUserService appUserService) {
        this.postService = postService;
        this.appUserService = appUserService;
    }

    @PostConstruct
    @Transactional
    public void initData(){
        AppUser admin = new AppUser(1L,"admin", "admin", "Bojan", "Dukovski", "biography...", "070123456", Role.ADMIN, null);
        AppUser user1 = new AppUser(4L, "LovelyGirl3", "Test123;", "Lovely", "Girl", "biography...", "070123456", Role.USER, null);
        AppUser user2 = new AppUser(2L,"Feminka22", "vm", "Viktor", "Meglenovski", "biography...", "070123456", Role.USER, null);
        AppUser user3 = new AppUser(3L,"prominent","hk","Hristina", "Krstevska", "biography...", "070123456", Role.DOCTOR, null);
        Post post1 = new Post(1L,"a,b,c", "Нов коронавирус со непознато потекло, назначен 2019-nCoV, кој се појави околу 12ти Декември 2019 во градот Вухан, Кина на големопродажен пазар за морска храна.", 4.22, user1);
        Post post2 = new Post(2L,"a,b,c", "Избегнував да ја отворам темава, избегнував и да читам деновиве.Но, морам да признаам дека сум малку исплашена. И да е човек најхрабар, тешко е дека ќе остане имун на информациите што се шират низ медиумите.", 1.22, user2);
        Post post3 = new Post(3L,"a,b,c", "Не паничете.Здравјето треба како и да е да си го чувате и да има и да нема некаква епидемија.Избегнувајте долго да сте во затворени простории со повеќе луѓе (автобуси, молови, маркети).Мијте раце, лице кога ќе дојдете дома. ", 0.22, user3);


        this.appUserService.register(admin.getUsername(),
                                     admin.getPassword(),
                                     admin.getPassword(),
                                     admin.getName(),
                                     admin.getSurname(),
                                     admin.getBiography(),
                                     admin.getPhoneNumber(),
                                     admin.getRole());
        this.appUserService.register(user1.getUsername(),
                                     user1.getPassword(),
                                     user1.getPassword(),
                                     user1.getName(),
                                     user1.getSurname(),
                user1.getBiography(),
                user1.getPhoneNumber(),
                                     user1.getRole());
        this.appUserService.register(user2.getUsername(),
                                     user2.getPassword(),
                                     user2.getPassword(),
                                     user2.getName(),
                                     user2.getSurname(),
                user2.getBiography(),
                user2.getPhoneNumber(),
                                     user2.getRole());
        this.appUserService.register(user3.getUsername(),
                                     user3.getPassword(),
                                     user3.getPassword(),
                                     user3.getName(),
                                     user3.getSurname(),
                user3.getBiography(),
                user3.getPhoneNumber(),
                                     user3.getRole());


        this.postService.save(post1.getKeywords(),
                              post1.getContent(),
                              post1.getRating(),
                              post1.getUser());

        this.postService.save(post2.getKeywords(),
                              post2.getContent(),
                              post2.getRating(),
                              post2.getUser());

        this.postService.save(post3.getKeywords(),
                              post3.getContent(),
                              post3.getRating(),
                              post3.getUser());
    }
}
