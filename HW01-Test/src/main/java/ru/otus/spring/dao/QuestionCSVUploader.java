package ru.otus.spring.dao;

import org.apache.commons.csv.CSVRecord;
import ru.otus.spring.domain.Question;

import java.io.IOException;

public interface QuestionCSVUploader {
    public Question upload(CSVRecord record) throws IOException;

}
