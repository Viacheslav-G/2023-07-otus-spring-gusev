package ru.otus.spring.service;

import ru.otus.spring.domain.Question;

public interface QuestionReceiveAnswerService {
    public int receive(Question question);
}
