package service;

import domain.Book;
import domain.Lecture;
import domain.Major;
import persistence.LectureRepository;

import java.util.ArrayList;

public class LectureService {
    private final LectureRepository lectureRepository = LectureRepository.getInstance();

    public Lecture findTarget(String id) {
        return lectureRepository.findById(Integer.parseInt(id));
    }

    public ArrayList<Lecture> findLectures(Major major) {
        return lectureRepository.findLecturesByIdAndGrade(major);
    }
}