package ru.otus.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.spring.dao.CSVResourceLoader;
import ru.otus.spring.dao.QuestionCSVUploader;
import ru.otus.spring.dao.QuestionCSVUploaderImpl;
import ru.otus.spring.domain.Test;
import ru.otus.spring.service.*;

@PropertySource("classpath:/test.properties")
@Configuration
public class DaoConfig {
    @Value("${questionCSVFile}")
    private String questionCSVFile;

    @Bean
    public QuestionCSVUploader questionCSVUploader() {
        return new QuestionCSVUploaderImpl();
    }

    @Bean
    public CSVResourceLoader csvResourceLoader() {

        CSVResourceLoader csvResourceLoader = new CSVResourceLoader();
        csvResourceLoader.setFileName(questionCSVFile);
        return csvResourceLoader;
    }

    @Bean
    public Test test() {
        return new Test();
    }

    @Bean
    public TestQuestionsUploader testQuestionsUploader() {
        return new TestQuestionsUploaderCSV(test(), csvResourceLoader(), questionCSVUploader());
    }

    @Bean
    public StudentImport studentImport() {
        return new StudentImportConsole();

    }

    @Bean
    public ReadLine readLineConsole() {
        return new ReadLineConsole();
    }

    @Bean
    public QuestionOutputService questionOutputconsole() {
        return new QuestionOutputConsole();
    }

}
