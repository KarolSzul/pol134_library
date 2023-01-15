package org.example.library.view;

import org.example.library.dao.UserDao;
import org.example.library.dao.UserProvider;
import org.example.library.model.Rental;

import java.util.List;

public class BorrowedBooksView implements View{

    private List<Rental> usersRentals;
    @Override
    public void display() {
        UserDao rentals = new UserDao();
        usersRentals = rentals.getRentalsOfUser();
        for (Rental rental: usersRentals) {
            System.out.println(rental.toString());
                    }
                }
}
