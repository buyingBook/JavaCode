package service;

import domain.Book;
import persistence.BookRepository;

import java.util.ArrayList;


public class BookService {
    private final BookRepository bookRepository = BookRepository.getInstance();

    public int totalcnt() {
        return bookRepository.totalCount();
    }

    public int totalcnt(String majorStr, String gradeStr) {
        String major = majorName(majorStr);
        int grade = gradeInt(gradeStr);
        if(major.equals("null") && grade<0)
            return bookRepository.totalCount();
        else if(major.equals("null"))
            return bookRepository.totalCount(grade);
        else if(grade < 0)
            return bookRepository.totalCount(major);
        else
            return bookRepository.totalCount(major, grade);
    }

    public ArrayList<Book> findBooks(int idx) {
        return bookRepository.findAll(idx);
    }

    public ArrayList<Book> findBooks(int idx, String majorStr, String gradeStr) {
        String major = majorName(majorStr);
        int grade = gradeInt(gradeStr);
        if(major.equals("null") && grade<0)
            return bookRepository.findAll(idx);
        else if(major.equals("null"))
            return bookRepository.findAll(idx, grade);
        else if(grade < 0)
            return bookRepository.findAll(idx, major);
        else
            return bookRepository.findAll(idx, major, grade);
    }

    public Book findTarget(String id) {
        return bookRepository.findById(Integer.parseInt(id));
    }


    private String majorName(String majorId) {
        switch (majorId) {
            case "cse": return "컴퓨터소프트웨어공학과";
            case "civil": return "토목공학과";
            case "chemistry": return "응용화학과";
            case "business": return "경영학과";
            default: return "null";
        }
    }

    private int gradeInt(String gradeStr) {
        switch (gradeStr) {
            case "1": return 1;
            case "2": return 2;
            case "3": return 3;
            case "4": return 4;
            default: return -1;
        }
    }
}
