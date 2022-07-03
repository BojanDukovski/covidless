package app.covidless.service.impl;

import app.covidless.model.AppUser;
import app.covidless.model.Post;
import app.covidless.model.Role;
import app.covidless.repository.AppUserRepository;
import app.covidless.repository.PostRepository;
import app.covidless.service.PostService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    public final PostRepository postRepository;
    public final AppUserRepository appUserRepository;

    public PostServiceImpl(PostRepository postRepository, AppUserRepository appUserRepository) {
        this.postRepository = postRepository;
        this.appUserRepository = appUserRepository;
    }

    @Override
    public List<Post> findAll() {
        return this.postRepository.findAll();
    }

    @Override
    public List<Post> findAllById(Long id) {
        return this.postRepository.findAllById(Collections.singleton(id)); //may be a problem
    }

    @Override
    public Post save(String keywords, String content, Double rating, AppUser user) {
        AppUser appUser = this.appUserRepository.findById(user.getId()).orElse(null);
        Post post = new Post(keywords, content, rating, appUser);
        return this.postRepository.save(post);
    }

    @Override
    public Post changeRating(Long id, Double rating) { //mathematical implement later!!!
        return null;
    }

    @Override
    public List<Post> findAllByUserRole(Role role) {
        return this.postRepository.findAllByUserRole(role);
    }

    @Override
    public List<Post> findAllByKeywordsContaining(String keyword) {
        return this.postRepository.findAllByKeywordsContaining(keyword);
    }

    @Override
    public Post findById(Long postId) {
        return this.postRepository.findById(postId).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        this.postRepository.deleteById(id);
    }
}
