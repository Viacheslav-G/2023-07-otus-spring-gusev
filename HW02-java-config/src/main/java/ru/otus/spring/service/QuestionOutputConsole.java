package ru.otus.spring.service;

import ru.otus.spring.domain.Question;

public class QuestionOutputConsole implements  QuestionOutputService {
    @Override
    public void output(Question question) {
        System.out.println(question.getText());
        if (question.getOptionalAnswers().size() > 0) {
            question.getOptionalAnswers().forEach(optionalAnswer -> System.out.println(optionalAnswer));
        }
    }
}
