package service;

import domain.Book;
import domain.Lecture;
import persistence.LectureRepository;

import java.util.ArrayList;

public class LectureService {
    private final LectureRepository lectureRepository = LectureRepository.getInstance();

    public Lecture findTarget(String id) {
        return lectureRepository.findById(Integer.parseInt(id));
    }
}