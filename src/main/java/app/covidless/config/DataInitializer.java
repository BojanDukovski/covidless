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
        AppUser doctor2 = new AppUser(3L,"hristina.krstevska","hk","Христина", "Крстевска", "Доктор по општа медицина, Битола.", "070123456", Role.DOCTOR, null);
        AppUser doctor1 = new AppUser(5L,"katerina.damevska","vm","Катерина", "Дамевска", "Доц.д-р.Катерина Дамевска од Универзитетската клиника за дерматологија во\n" +
                "Скопје, доби согласност за ре-публикување од часописот, авторите на текстот и од\n" +
                "Претседателот на Кинесекото здружение на дерматолози.\n" +
                "Оваа публикација и ре-публикација не се спонзорирани.", "070123456", Role.DOCTOR, null);
        Post post1 = new Post(1L,"коронавирус, covid, korona", "Нов коронавирус со непознато потекло, назначен 2019-nCoV, кој се појави околу 12ти Декември 2019 во градот Вухан, Кина на големопродажен пазар за морска храна, кој најпрво се сметаше дека се пренесува од животно на човек, па потоа се откри дека се пренесува од човек на човек. Времето на инкубација на вирусот е 5-7 дена (според претходната епидемија САРС во 2003 која уби 774 луѓе), кога всушност се пренесува вирусот.\n" +
                "\n" +
                "Симптомите на овој вирус се исти како настинка: болки во грлото, течење на носот, кашлица, проблеми со дишењето итн.\n" +
                "\n" +
                "Овој вирус досега уби 56 луѓе, а бројот на заразени моментално е 2,092 од кои најголем број во Кина (2,042), потоа во соседни држави во Азија, Австралија(4), САД(3), Канада(1) Франција(3) и потенцијални случаи во Хрватска.\n" +
                "\n" +
                "Дали сметате дека кај нас многу малку се обрнува внимание на оваа епидемија што од ден во ден се шири во различни држави?\n" +
                "Дали треба да трчаме во болница ако имаме сипмтоми на една обична настинка?\n" +
                "Дали има простор за паника и на кој начин да се заштитиме?\n" +
                "Дали нашето здравство е компетентно да го дијагностицира и лекува овој вирус? ", 4.22, user1);
        Post post2 = new Post(2L,"коронавирус, covid, korona", "Избегнував да ја отворам темава, избегнував и да читам деновиве.\n" +
                "\n" +
                "Хипохондрик сум.\n" +
                "\n" +
                "Но, морам да признаам дека сум малку исплашена. И да е човек најхрабар, тешко е дека ќе остане имун на информациите што се шират низ медиумите. Особено зашто некои наслови се пишани за намерно создавање паника со цел да се генерираат повеќе кликови.\n" +
                "\n" +
                "Баш пред малку отворив еден германски сајт, насловот беше нешто во стилот ,,Корона вирусот во Германија'', a статијата почнуваше со реченицата дека постоело само сомневање за еден случај и дека се докажало дека жената боледува од нешто друго.\n" +
                "\n" +
                "Како и да е...\n" +
                "Добрата страна е на ова е што луѓето знаат за што се работи, отприлика, па може навреме да преземат мерки да се заштитат себе.\n" +
                "\n" +
                "Се согласувам со @John Snow. Намерно пуштено, но за тоа колку и како ќе се шири, тука веќе се губи контролата. Се надевам дека брзо ќе се смири ситуацијата. ", 1.22, user2);
        Post post3 = new Post(3L,"коронавирус, covid, korona", "Не паничете.\n" +
                "Здравјето треба како и да е да си го чувате и да има и да нема некаква епидемија.\n" +
                "Избегнувајте долго да сте во затворени простории со повеќе луѓе (автобуси, молови, маркети).\n" +
                "Мијте раце, лице кога ќе дојдете дома.\n" +
                "Ако гледате дека некој (во затворена просторија) кива/кашла со или без рака на уста поттргнете се од него.\n" +
                "Најпросто, пазете си го здравјето и дур не е алармантно не паничете.\n" +
                "Вирусов е намерно пуштен јасно е ко ведро небо.Само да ми је знати со кој мозок и која потреба го направиле тоа ако се Кина пренаселени и им е гајле дали ќе им умрат неколку иљади луѓе, ние по светов не сме дужни да им ги испаштаме хировите.", 0.22, user2);
        Post doctorsPost2 = new Post(4L, "коронавирус, covid, korona", "Лицето-возач на превозно средство (ладилник) , странски државјанин при влез во\n" +
                "Република Северна Македонија, задолжително да носи лична заштитна опреама (маска,\n" +
                "ракавици за еднократна употреба)", null, doctor2);
        Post doctorsPost1 = new Post(5L, "коронавирус, covid, korona", "Здравствените работници кои работат на превенција и лекување на болеста COVID-\n" +
                "19 се склони кон оштетување на кожата и мукозните мембрани, што може да\n" +
                "доведе до појава на акутни и хронични дерматити, секундарни инфекции и\n" +
                "агравација на постоечките кожни болести. Ова е консензус на Kинеските експерти,\n" +
                "а се однесува на преземање адекватни мерки на претпазливост и заштита, совети за\n" +
                "правилно миење на рацете и заштита, поврзана со употреба на медицински\n" +
                "ракавици, употреба на заштитни маски и очила , UV-протекција, заштита на очите,\n" +
                "носот и оралната мукоза, ушите и косата. Неопходно е стриктно следење на\n" +
                "упатствата за носење на заштитна опрема и спецификација на миење и\n" +
                "стерилизација. Недоволна, но и прекумерна заштита ќе има негативни ефекти на\n" +
                "кожата и мукозните мембрани. Истовремено, препорачливо е да се употребуваат\n" +
                "емолиенти за нега,за да се постигне подобра заштита.", null, doctor1);


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
        this.appUserService.register(doctor1.getUsername(),
                                     doctor1.getPassword(),
                                     doctor1.getPassword(),
                                     doctor1.getName(),
                                     doctor1.getSurname(),
                                     doctor1.getBiography(),
                                     doctor1.getPhoneNumber(),
                                     doctor1.getRole());
        this.appUserService.register(doctor2.getUsername(),
                                     doctor2.getPassword(),
                                     doctor2.getPassword(),
                                     doctor2.getName(),
                                     doctor2.getSurname(),
                                     doctor2.getBiography(),
                                     doctor2.getPhoneNumber(),
                                     doctor2.getRole());


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
        this.postService.save(doctorsPost1.getKeywords(),
                              doctorsPost1.getContent(),
                              doctorsPost1.getRating(),
                              doctorsPost1.getUser());
        this.postService.save(doctorsPost2.getKeywords(),
                              doctorsPost2.getContent(),
                              doctorsPost2.getRating(),
                              doctorsPost2.getUser());
    }
}
