package ru.otus.spring.dao;

import ru.otus.spring.domain.Student;

public class StudentDaoSimple implements StudentDao {
    @Override
    public Student findByFirstAndLastName(String firstName, String lastName) {
        return new Student(firstName, lastName);
    }


}
