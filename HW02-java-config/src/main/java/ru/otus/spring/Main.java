package ru.otus.spring;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.domain.Question;
import ru.otus.spring.domain.Test;
import ru.otus.spring.domain.Student;
import ru.otus.spring.service.*;

@ComponentScan
@Configuration

public class Main {

    public static void main(String[] args) {

       AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        Test test = context.getBean(Test.class);
        StudentImport studentImport = context.getBean(StudentImport.class);
        Student student1 = studentImport.readStudent();
        int result = 0;
        ReadLine readLineConsole = context.getBean(ReadLineConsole.class);
        QuestionOutputService questionOutputConsole = context.getBean(QuestionOutputConsole.class);
        QuestionReceiveAnswerService questionReceiveAnswerConsole = context.getBean(QuestionReceiveAnswerConsole.class);
        for (Question question : test.getQuestions()) {
            result = result + question.ask(questionOutputConsole, questionReceiveAnswerConsole);
        }
        test.inputResult(student1, result);
        RequiredResult requiredResult = context.getBean(RequiredResult.class);
        test.setCreditScore(requiredResult.getRequiredResult());
        System.out.println(test.compareResultToCreditScore(student1));

    }
}
