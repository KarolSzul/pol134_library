package org.example.library;

import org.example.library.api.UserRole;
import org.example.library.view.BooksView;
import org.example.library.view.LoginView;
import org.example.library.view.View;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UserRole userRole = UserRole.find("USER");
        System.out.println(userRole.USER.getName());
        View view = new BooksView();
        view.display();

    }
}
