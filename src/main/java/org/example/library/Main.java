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
//        UserRole userRole = UserRole.find("USER");
//        System.out.println(userRole.USER.getName());
//
//        View view = new LoginView(Optional.empty());
//        view.display();
//        View borrowedBooksView = new BorrowedBooksView();
//        borrowedBooksView.display();

//        final String FIND_AVAILABLE_BOOKS = "from User";


//            Session session = HibernateUtil.getSessionFactory().openSession();
//            Query<User> query = session.createQuery(FIND_AVAILABLE_BOOKS, User.class);
//            List<User> books = query.getResultList();
//            session.close();
//        for (User user: books) {
//            System.out.println(user.toString());
//        }

        View view = new NewUserView(Optional.empty());
        view.display();

    }

}

