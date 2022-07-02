package app.covidless.service.impl;

import app.covidless.exceptions.InvalidArgumentsException;
import app.covidless.exceptions.InvalidUserCredentialsException;
import app.covidless.model.AppUser;
import app.covidless.repository.AppUserRepository;
import app.covidless.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AppUserRepository userRepository;

    public AuthServiceImpl(AppUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public AppUser login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username,
                password).orElseThrow(InvalidUserCredentialsException::new);
    }

}
