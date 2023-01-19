package org.example.library.controller;

import org.example.library.ActiveUser;
import org.example.library.ApplicationContext;
import org.example.library.dao.UserDao;
import org.example.library.model.Rental;
import org.example.library.model.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BooksController {

    public List<Rental> getRentalsOfUser(UserDao userDao) {
        // Do przeniesienia
        ActiveUser activeUser = ApplicationContext.getActiveUser();
        Optional<User> user = userDao.findUserByLogin(activeUser.getLogin());
        return user.stream().
                flatMap(user1 -> user1.getRentals().stream())
                .collect(Collectors.toList());
    }
}
