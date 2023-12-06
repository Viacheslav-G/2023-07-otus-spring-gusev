package ru.otus.spring.domain;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private List<Question> questions;

    public Test(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public Test() {
        this.questions = new ArrayList<Question>();
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void printQuestions() {
        if (questions.isEmpty()) {
            System.out.println("No questions was uploaded");
        } else {
            questions.stream().forEach(i -> System.out.println(i + " "));

        }
    }

}
