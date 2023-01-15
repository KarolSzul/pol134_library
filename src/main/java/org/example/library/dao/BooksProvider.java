package org.example.library.dao;

import org.example.library.model.Book;

import java.util.List;

public interface BooksProvider {

    List<Book> findAvailableBooks();
}
