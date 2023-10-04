package com.epam.quiz.service;

import com.epam.quiz.model.Question;
import com.epam.quiz.repository.QuestionRepository;
import com.epam.quiz.utility.enm.SectionTag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/* Completed all test case */
@ExtendWith({MockitoExtension.class})
 class SectionServiceImplTest {

    @Mock
    private QuestionRepository questionRepository;


    @InjectMocks
    private SectionServiceImpl sectionService;

    @Test
    void getSectionNameNumberListPassTest()
    {
        when(questionRepository.findBySectionTag(SectionTag.valueOf("CORE_JAVA"))).thenReturn(new ArrayList<Question>());
        assertNotNull(sectionService.getSectionNameNumberList("CORE_JAVA"));
    }

    @Test
    void getSectionNameNumberListFailTest()
    {
        when(questionRepository.findBySectionTag(SectionTag.valueOf("CORE_JAVA"))).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class,()->sectionService.getSectionNameNumberList("CORE_JAVA"));
    }

}
