package ru.otus.spring.domain;

import java.util.List;

public class Question {
    private final String text;

    private final String correctAnswer;

    private List<String> optionalAnswers;

    public Question(String text, String correctAnswer) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        //this.optionalAnswers = new List<>();
    }

    public String getText() {
        return text;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setOptionalAnswers(List<String> optionalAnswers) {
        this.optionalAnswers = optionalAnswers;
    }

    @Override
    public String toString() {
        if (optionalAnswers.isEmpty()) {
            return "Question{" +
                    "text='" + text + '\'' +
                    ", correctAnswer='" + correctAnswer + '\'' +
                    '}';
        } else {
            return "Question{" +
                    "text='" + text + '\'' +
                    ", correctAnswer='" + correctAnswer + '\'' +
                    ", optionalAnswers=" + optionalAnswers.toString() +
                    '}';
        }
    }
}
