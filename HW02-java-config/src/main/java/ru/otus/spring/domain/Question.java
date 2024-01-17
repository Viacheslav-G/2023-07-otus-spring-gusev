package ru.otus.spring.domain;

import ru.otus.spring.service.QuestionOutputService;
import ru.otus.spring.service.QuestionReceiveAnswerService;
import java.util.List;

public class Question {

    private final String text;

    private final String correctAnswer;

    private List<String> optionalAnswers;

    public Question(String text, String correctAnswer) {
        this.text = text;
        this.correctAnswer = correctAnswer;

    }

    public String getText() {
        return text;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getOptionalAnswers() {
        return optionalAnswers;
    }

    public String getOptionalAnswer(int number) {
        return optionalAnswers.get(number);
    }

    public void setOptionalAnswers(List<String> optionalAnswers) {
        this.optionalAnswers = optionalAnswers;
    }

    public int ask(QuestionOutputService questionOutput, QuestionReceiveAnswerService questionReceiveAnswer) {
        questionOutput.output(this);
        return questionReceiveAnswer.receive(this);
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
