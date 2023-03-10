package org.example.library.service;

import org.example.library.api.UserLoginData;
import org.example.library.dao.UserProvider;
import org.example.library.model.User;

import java.util.Optional;

public class UserService implements UserLoginChecker {

    private final UserProvider userProvider;

    public UserService(UserProvider userProvider) {
        this.userProvider = userProvider;
    }

    @Override
    public Optional<User> checkAndGet(UserLoginData userLoginData) {
        var test = userProvider.findUserByLogin(userLoginData.getLogin());
        return userProvider.findUserByLogin(userLoginData.getLogin())
                .filter(user -> checkPassword(user, userLoginData));
    }

    private boolean checkPassword(User user, UserLoginData userLoginData) {
        return user.getPassword().equals(userLoginData.getPassword());
    }

    public boolean checkLoginExisting(String login) {
        Optional<User> userByLogin = userProvider.findUserByLogin(login);
        return userByLogin.isPresent();
    }
}
