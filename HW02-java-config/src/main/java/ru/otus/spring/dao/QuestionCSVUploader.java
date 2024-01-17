package ru.otus.spring.dao;

import org.apache.commons.csv.CSVRecord;
import ru.otus.spring.domain.Question;

public interface QuestionCSVUploader {
    public Question upload(CSVRecord record);

}
