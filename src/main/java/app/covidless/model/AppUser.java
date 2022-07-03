package app.covidless.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity
public class AppUser implements UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String name;

    private String surname;

    @Column(length = 50000)
    private String biography;

    private String phoneNumber;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToMany
    private List<Post> posts;

    private boolean isAccountNonExpired = true;
    private boolean isAccountNonLocked = true;
    private boolean isCredentialsNonExpired = true;
    private boolean isEnabled = true;

    public AppUser(){}

    public AppUser(String username, String password, String name, String surname, String biography, String phoneNumber, Role role, List<Post> posts) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.biography = biography;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.posts = posts;
    }

    public AppUser(String username, String encode, String name, String surname, Role role) {
        this.username = username;
        this.password = encode;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.biography = null;
        this.phoneNumber = null;
        this.posts = null;
    }

    public AppUser(Long id, String username, String password, String name, String surname, String biography, String phoneNumber, Role role, List<Post> posts) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.biography = biography;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.posts = posts;
    }

    public AppUser(String username, String encode, String name, String surname, String biography, String contact, Role role) {
        this.username = username;
        this.password = encode;
        this.name = name;
        this.surname = surname;
        this.biography = biography;
        this.phoneNumber = contact;
        this.role = role;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
