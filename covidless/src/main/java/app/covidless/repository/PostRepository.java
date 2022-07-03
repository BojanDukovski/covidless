package app.covidless.repository;

import app.covidless.model.Post;
import app.covidless.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByUserRole(Role role);

    List<Post> findAllByKeywordsContaining(String keyword);
}
