package org.example.library.controller;

import org.example.library.ActiveUser;
import org.example.library.ApplicationContext;
import org.example.library.dao.RentalDao;
import org.example.library.model.Rental;

import java.util.List;

public class BooksController {

    public List<Rental> getRentalsOfUser(RentalDao rentalDao) {
        ActiveUser activeUser = ApplicationContext.getActiveUser();
        return rentalDao.findRentalByLogin(activeUser.getLogin());
    }
}
