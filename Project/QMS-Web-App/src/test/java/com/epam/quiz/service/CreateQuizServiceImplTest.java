package com.epam.quiz.service;

import com.epam.quiz.model.Question;
import com.epam.quiz.repository.QuestionRepository;
import com.epam.quiz.utility.cls.RandomNumber;
import com.epam.quiz.utility.enm.SectionTag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
 class CreateQuizServiceImplTest {

   @Mock
   private SectionService sectionService;
   @Mock
   private QuestionRepository questionRepository;

    @InjectMocks
    private CreateQuizServiceImpl createQuizService;

    @Test
    void test_generateQuestionNumberList()
    {

        when(sectionService.getSectionQuestionIDList(anyString())).thenReturn(Arrays.asList(1,2,3,3,4,5,5));
//        when(RandomNumber.getQuestionNumberList(any(ArrayList.class))).thenReturn(Set.of(1,2,3,3,4,5,5));
        assertNotNull(createQuizService.generateQuestionNumberList("CORE_JAVA"));
    }

    @Test
    void test_createQuestionListBySectionName()
    {
        when(questionRepository.findBySectionTag(any(SectionTag.class))).thenReturn(new ArrayList<Question>());
        when(sectionService.getSectionQuestionIDList(anyString())).thenReturn(Arrays.asList(1,2,3,3,4,5,5));
        assertNotNull(createQuizService.createQuestionListBySectionName("CORE_JAVA"));

    }

}
