package org.example.library.view;

import org.example.library.controller.BooksController;
import org.example.library.dao.UserDao;
import org.example.library.model.Rental;

import java.util.List;

public class BorrowedBooksView implements View{

    private final BooksController booksController;
    private final UserDao userDao;

    public BorrowedBooksView() {
        this.userDao =  new UserDao();
        this.booksController = new BooksController();
            }

    private List<Rental> usersRentals;
    @Override
    public void display() {
        usersRentals = booksController.getRentalsOfUser(userDao);
        for (Rental rental: usersRentals) {
            System.out.println("Title: " + rental.getBook().getTitle() + "Date of rent: " +
                    rental.getRentDate() + "Date of return: " + rental.getDueDate());
                    }
                }
}
