package service;

import domain.Book;
import persistence.BookRepository;

import java.util.ArrayList;

public class BookService {
    private final BookRepository bookRepository = BookRepository.getInstance();

    public ArrayList<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findTarget(String id) {
        return bookRepository.findById(Integer.parseInt(id));
    }
}
