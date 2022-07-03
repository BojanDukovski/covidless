package app.covidless.service;

import app.covidless.model.AppUser;
import app.covidless.model.Post;
import app.covidless.model.Role;
import app.covidless.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    List<Post> findAllById(Long id);
    Post save (String keywords, String content, Double rating, AppUser user);
    //Post edit (Post post)
    Post changeRating (Long id, Double rating);

    List<Post> findAllByUserRole(Role role);

    List<Post> findAllByKeywordsContaining(String keyword);
}
