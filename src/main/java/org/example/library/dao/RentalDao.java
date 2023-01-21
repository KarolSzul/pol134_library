package org.example.library.dao;

import org.example.library.model.Rental;
import org.example.library.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RentalDao implements RentalProvider {

    private static final String SEARCH_BY_LOGIN_QUERY = "select r from Rental as r " +
            "left join fetch r.user as u " +
            "where u.login=:login";

    @Override
    public List<Rental> findRentalByLogin(String login) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Rental> query = session.createQuery(SEARCH_BY_LOGIN_QUERY, Rental.class)
                .setParameter("login", login);
        List<Rental> rental = query.getResultList();
        session.close();
        return rental;
    }
}
