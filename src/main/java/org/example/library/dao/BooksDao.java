package org.example.library.dao;

import org.example.library.model.Book;
import org.example.library.model.User;
import org.example.library.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class BooksDao implements BooksProvider{

    private static final String FIND_AVAILABLE_BOOKS = "from Book b where b.amountAvailable > 0";


    @Override
    public List<Book> findAvailableBooks() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Book> query = session.createQuery(FIND_AVAILABLE_BOOKS, Book.class);
        List<Book> books = query.getResultList();
        session.close();
        return books;
    }
}
