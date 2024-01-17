package ru.otus.spring.service;

import org.springframework.core.io.Resource;
import ru.otus.spring.domain.Test;

public interface TestQuestionsUploader {
    public void uploadQuestions(Test test, Resource resource);
}
