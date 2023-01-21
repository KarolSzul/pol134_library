package org.example.library.view;

import org.example.library.dao.BooksDao;
import org.example.library.dao.BooksProvider;
import org.example.library.model.Book;

import java.util.List;

public class BooksView implements View {
    private List<Book> availableBooks;

    @Override
    public void display() {
        BooksProvider books = new BooksDao();
        availableBooks = books.findAvailableBooks();
        for (Book book : availableBooks) {
            System.out.println(book.getIsbn()+ "  " + book.getTitle()+ "  " + book.getCategory()+ "  " + book.getAuthor()+ "  " + book.getAmountAvailable());
        }
    }
}
