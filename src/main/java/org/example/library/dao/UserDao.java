package org.example.library.dao;

import org.example.library.ActiveUser;
import org.example.library.ApplicationContext;
import org.example.library.model.Book;
import org.example.library.model.Rental;
import org.example.library.model.User;
import org.example.library.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserDao implements UserProvider {

    private static final String SEARCH_BY_LOGIN_QUERY = "from User u " +
//            "join fetch u.roles " +
            "join fetch u.rentals r " +
            "join fetch r.book b " +
            "where u.login=:login";

    @Override
    public Optional<User> findUserByLogin(String login) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<User> query = session.createQuery(SEARCH_BY_LOGIN_QUERY, User.class)
                .setParameter("login", login);
        Optional<User> user = query.getResultList().stream().findFirst();
        session.close();
        return user;
    }



}
