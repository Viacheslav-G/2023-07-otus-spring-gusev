package ru.otus.spring.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.Resource;
import ru.otus.spring.dao.CSVResourceLoader;
import ru.otus.spring.dao.QuestionCSVUploader;
import ru.otus.spring.domain.Question;
import ru.otus.spring.domain.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class TestQuestionsUploaderCSV implements  TestQuestionsUploader {
    private Test test;

    private CSVResourceLoader loader;

    private QuestionCSVUploader questionUploader;

    public TestQuestionsUploaderCSV (Test test, CSVResourceLoader loader, QuestionCSVUploader questionUploader) {
        this.test = test;
        this.loader = loader;
        this.questionUploader = questionUploader;
        try {
            uploadQuestions(this.test, this.loader.getResource());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void uploadQuestions(Test test, Resource resource) throws IOException {

        List<Question> questionList = new ArrayList<Question>();
        try (
                Reader reader = Files.newBufferedReader(resource.getFile().toPath());
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter(';')
                        .withFirstRecordAsHeader());
        ) {
            for (CSVRecord record : csvParser) {
                Question question = questionUploader.upload(record);
                questionList.add(question);
            }
        }
        test.setQuestions(questionList);
    }
}
