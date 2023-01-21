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

public class UserDao implements UserProvider, UserLoader {

    private static final String SEARCH_BY_LOGIN_QUERY = "select u from User as u " +
            "left join fetch u.roles " +
            "left join fetch u.address " +
            "left join fetch u.rentals as r " +
            "left join fetch r.book as b " +
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


    @Override
    public void addNewUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.persist(user);
        session.getTransaction().commit();
        session.close();

    }
}
