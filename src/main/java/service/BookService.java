package service;

import domain.Book;
import domain.Criteria;
import persistence.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookService {
    private final BookRepository bookRepository = BookRepository.getInstance();

    public int totalcnt() {
        return bookRepository.totalCount();
    }
    public ArrayList<Book> findBooks(int idx) {
        return bookRepository.findAll(idx);
    }
    public Book findTarget(String id) {
        return bookRepository.findById(Integer.parseInt(id));
    }
}
