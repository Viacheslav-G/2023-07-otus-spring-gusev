package ru.otus.spring.service;

import ru.otus.spring.domain.Student;

public class StudentImportConsole implements StudentImport {
    private String lastName;

    private String firstName;

    @Override
    public Student readStudent() {
        ReadLine readLine = new ReadLineConsole();
        lastName = readLine.getLine("Last Name");
        firstName = readLine.getLine("First Name");
        return new Student(firstName, lastName);

    }
}
