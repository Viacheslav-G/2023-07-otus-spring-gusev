import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.dao.CSVResourceLoader;
import ru.otus.spring.dao.QuestionCSVUploader;
import ru.otus.spring.dao.QuestionCSVUploaderImpl;
import ru.otus.spring.service.RequiredResult;
import ru.otus.spring.service.TestQuestionsUploaderCSV;

import java.io.IOException;
import java.nio.file.Files;

public class RequiredResultTest {

    @Test
    @DisplayName("Check Required Result equals to expected value")
    void requiredResultTest(){
        int requiredResult = 3;
        RequiredResult requiredResult1 = new RequiredResult(requiredResult);
        Assertions.assertEquals(requiredResult, requiredResult1.getRequiredResult());
    }

    @Test
    @DisplayName("Integration test of questions CSV uploader")
    void testQuestionsUploaderCSVTest(){
        ru.otus.spring.domain.Test mockTest = new ru.otus.spring.domain.Test();
        CSVResourceLoader mockResourceLoader = new CSVResourceLoader();
        QuestionCSVUploader mockQuestionCSVUploader = new QuestionCSVUploaderImpl();

        mockResourceLoader.setFileName("Questionnarie.csv");
        TestQuestionsUploaderCSV testUploader = new TestQuestionsUploaderCSV(mockTest, mockResourceLoader, mockQuestionCSVUploader );
        testUploader.uploadQuestions(mockTest, mockResourceLoader.getResource());

        try (CSVParser parser = new CSVParser(Files.newBufferedReader(mockResourceLoader.getResource().getFile().toPath()), CSVFormat.DEFAULT.withDelimiter(';').withFirstRecordAsHeader());
        ){
            Assertions.assertEquals(parser.getRecords().size(), mockTest.getQuestions().size() );
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}

