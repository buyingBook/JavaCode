package service;

import domain.Lecture;
import domain.Major;
import persistence.MajorRepository;

import java.util.ArrayList;

public class MajorService {
    private final MajorRepository majorRepository = MajorRepository.getInstance();

    public int totalcnt() {
        return majorRepository.totalCount();
    }

    public ArrayList<Major> findAll(int pageStart) {
        return majorRepository.findAll(pageStart);
    }

    public Major findById(String id) {
        return majorRepository.findById(id);
    }
}
