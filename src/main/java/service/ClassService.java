package service;

import domain.Class;
import persistence.ClassRepository;

import java.util.ArrayList;

public class ClassService {
    private final ClassRepository classRepository = ClassRepository.getInstance();

    public ArrayList<Class> findClass() {
        return classRepository.findAll();
    }
}