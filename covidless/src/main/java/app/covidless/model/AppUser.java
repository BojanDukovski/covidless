package app.covidless.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class AppUser {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String biography;

    private String phoneNumber;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToMany
    private List<Post> posts;

    public AppUser(){}

    public AppUser(String name, String surname, String biography, String phoneNumber, Role role, List<Post> posts) {
        this.name = name;
        this.surname = surname;
        this.biography = biography;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.posts = posts;
    }
}
