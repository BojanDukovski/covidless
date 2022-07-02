package app.covidless.service;

import app.covidless.model.AppUser;

public interface AuthService {
    AppUser login(String username, String password);
}
