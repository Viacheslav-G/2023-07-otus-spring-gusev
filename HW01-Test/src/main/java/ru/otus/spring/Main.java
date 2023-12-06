package ru.otus.spring;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.domain.Test;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        Test test = context.getBean(Test.class);
        test.printQuestions();

    }
}
