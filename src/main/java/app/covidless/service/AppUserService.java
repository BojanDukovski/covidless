package app.covidless.service;

import app.covidless.model.AppUser;
import app.covidless.model.Role;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

public interface AppUserService {
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;

    AppUser register(String username, String password, String repeatPassword, String name, String surname, String biography, String contact, Role role);

    AppUser findByUsername(String username);

    AppUser findById(Long id);

}
