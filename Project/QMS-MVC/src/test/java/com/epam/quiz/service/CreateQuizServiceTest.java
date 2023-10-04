package com.epam.quiz.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CreateQuizServiceTest {

    /**
     * checking for method generateQuestionListBySectionName
     * TO-LIST
     * 1) check weather the question is valid generated
     */

    @Autowired
    private CreateQuizService createQuizService;


    @Test
    void generateQuestionListBySectionNameTest1() {
        Assertions.assertAll(() -> Assertions.assertEquals(5, createQuizService.generateQuestionListBySectionName("CORE_JAVA").size()),
                () -> Assertions.assertEquals(5, createQuizService.generateQuestionListBySectionName("ADVANCE_JAVA").size()),
                () -> Assertions.assertEquals(5, createQuizService.generateQuestionListBySectionName("JAVA_EIGHT").size()));
    }

    @Test
    void getQuestionNumberListBySectionNameTest() {
        Assertions.assertAll(() -> Assertions.assertEquals(5, createQuizService.getQuestionNumberListBySectionName("CORE_JAVA").size()),
                () -> Assertions.assertEquals(5, createQuizService.getQuestionNumberListBySectionName("ADVANCE_JAVA").size()),
                () -> Assertions.assertEquals(5, createQuizService.getQuestionNumberListBySectionName("JAVA_EIGHT").size()));
    }

}
