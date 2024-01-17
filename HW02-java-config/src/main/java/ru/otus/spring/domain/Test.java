package ru.otus.spring.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    private List<Question> questions;

    private int creditScore;

    private Map<Student, Integer> results;

    public Test(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public Test() {
        this.questions = new ArrayList<Question>();
        this.results = new HashMap<Student, Integer>();
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void printQuestions() {
        if (questions.isEmpty()) {
            System.out.println("No questions were uploaded");
        } else {
            questions.stream().forEach(i -> System.out.println(i + " "));

        }
    }

    public Map<Student, Integer> getResults() {
        return results;
    }

    public void inputResult(Student student, Integer result) {
        this.results.put(student, result);
    }

    public int getStudentResult(Student student) {
        return results.get(student);
    }

    public String compareResultToCreditScore(Student student) {
        if (getStudentResult(student) >= this.creditScore) {
            return "Credited";
        } else {
            return "Non-Credited";
        }
    }

}
