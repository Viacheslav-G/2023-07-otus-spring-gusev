package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RequiredResult {
    private final int requiredResult;

    public RequiredResult(@Value("${credit}") int requiredResult) {
        this.requiredResult = requiredResult;
    }

    public int getRequiredResult() {
        return requiredResult;
    }
}
