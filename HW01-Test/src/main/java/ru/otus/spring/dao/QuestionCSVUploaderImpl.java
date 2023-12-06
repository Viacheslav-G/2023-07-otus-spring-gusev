package ru.otus.spring.dao;

import ru.otus.spring.domain.Question;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestionCSVUploaderImpl implements QuestionCSVUploader {


    public Question upload(CSVRecord record) throws IOException {
        //Question question = new Question(record.get("Question"), record.get("CorrectAnswer") );
        String questionString = "";
        String correctAnswerString = "";
        List<String> optionalAnswerList = new ArrayList<String>();
        for (int i = 0; i < record.getParser().getHeaderNames().size(); i++) {
            String columnName = record.getParser().getHeaderNames().get(i);
            if ("Question".equals(columnName)) {
                questionString  = record.get(i);
            }
            if ("CorrectAnswer".equals(columnName)) {
                correctAnswerString  = record.get(i);
            }
            if ("OptionalAnswer".equals(columnName)) {
                optionalAnswerList.add(record.get(i));
            }
        }
        Question question = new Question(questionString, correctAnswerString);
        question.setOptionalAnswers(optionalAnswerList.stream().filter(StringUtils::isNotEmpty).toList());
        return question;
    }
}
