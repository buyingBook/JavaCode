package service;

import domain.BuyBook;
import persistence.BookRepository;
import persistence.BuyBookRepository;

public class BuyBookService {
    private final BuyBookRepository buyBookRepository = BuyBookRepository.getInstance();
    public void inputInfo(BuyBook buy) {
        buyBookRepository.inputInfo(buy);
    }
}
