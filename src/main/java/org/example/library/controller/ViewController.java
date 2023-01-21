package org.example.library.controller;

import org.example.library.ActiveUser;
import org.example.library.ApplicationContext;
import org.example.library.api.UserRole;
import org.example.library.model.Role;
import org.example.library.view.BooksView;
import org.example.library.view.BorrowedBooksView;
import org.example.library.view.NewUserView;
import org.example.library.view.View;

import java.util.Optional;
import java.util.Scanner;

public class ViewController {
    private final Scanner scanner;

    public ViewController() {
        this.scanner = new Scanner(System.in);
    }

    public void showMenu(ActiveUser activeUser) {
        System.out.println("Wybierz co chcesz zrobic:");
        if (activeUser.getUserRoles().contains(UserRole.ADMIN)) {
            showAdminView();
            int nextInt = scanner.nextInt();
            switch (nextInt) {
                case 1:
                    View newUserView = new NewUserView(Optional.empty());
                    newUserView.display();
                    showMenu(activeUser);
                    break;
                case 2:
                    //
                    break;
            }
        }
        if (activeUser.getUserRoles().contains(UserRole.USER)) {
            showUserView();
            int nextInt = scanner.nextInt();
            switch (nextInt) {
                case 1:
                    View booksView = new BooksView();
                    booksView.display();
                    showMenu(activeUser);
                    break;
                case 2:
                    View borrowedBooksView = new BorrowedBooksView();
                    borrowedBooksView.display();
                    showMenu(activeUser);
                    break;
            }
        }
    }

    public void showUserView() {
        System.out.println("1. Wyswietl dostepne ksiazki");
        System.out.println("2. Wyswietl wypozyczone ksiazki");
    }

    public void showAdminView() {
        System.out.println("1. Dodaj nowego uzytkownia");
        System.out.println("2. Zwrot ksiazki");
    }
}
