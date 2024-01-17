package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.otus.spring.domain.Question;

@Component("QuestionReceiveAnswerService")
public class QuestionReceiveAnswerConsole implements  QuestionReceiveAnswerService {

    private ReadLine readLine;

    public QuestionReceiveAnswerConsole(@Qualifier("readLineConsole")  ReadLine readLine) {
        this.readLine = readLine;
    }


    @Override
    public int receive(Question question) {

        if (readLine.getLine("answer").equals(question.getCorrectAnswer())) {
            return  1;
        }  else {
            return 0;
        }


    }
}
