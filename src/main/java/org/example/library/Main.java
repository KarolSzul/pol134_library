package org.example.library;

import org.example.library.api.UserRole;
import org.example.library.model.Book;
import org.example.library.model.User;
import org.example.library.utils.HibernateUtil;
import org.example.library.view.*;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        View view = new LoginView(Optional.empty());
        view.display();
    }

}

