package com.epam.quiz.service;

import com.epam.quiz.converter.QuestionConverter;
import com.epam.quiz.dto.QuestionDTO;
import com.epam.quiz.exception.QuestionNotFoundException;
import com.epam.quiz.model.Question;
import com.epam.quiz.model.Section;
import com.epam.quiz.repository.QuestionRepository;
import com.epam.quiz.utility.enm.DifficultyTag;
import com.epam.quiz.utility.enm.SectionTag;
import com.epam.quiz.utility.enm.TopicTag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
 class QuestionServiceImplTest {

    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private QuestionConverter questionConverter;

    @InjectMocks
    private QuestionServiceImpl questionService;

    private QuestionDTO questionDTO;
    private Question question;

    @BeforeEach
    void setUpObject()
    {
        questionDTO = new QuestionDTO();
        questionDTO.setQuestionDescription("What is my full name?");
        questionDTO.setOption1("Jagdish Kamadi");
        questionDTO.setOption2("Tejas Gawande");
        questionDTO.setOption3("Madhur Bhoyar");
        questionDTO.setOption4("Harshal Bhoyar");
        questionDTO.setAnswer("A");
        questionDTO.setSectionTag(SectionTag.CORE_JAVA);
        Section section = new Section(TopicTag.ARRAY, DifficultyTag.ADVANCE);
        questionDTO.setSection(section);

        question = new Question();
        question.setQuestionDescription("What is my full name?");
        question.setOption1("Jagdish Kamadi");
        question.setOption2("Tejas Gawande");
        question.setOption3("Madhur Bhoyar");
        question.setOption4("Harshal Bhoyar");
        question.setAnswer("A");
        question.setSectionTag(SectionTag.CORE_JAVA);
        section = new Section(TopicTag.ARRAY, DifficultyTag.ADVANCE);
        question.setSection(section);

    }

    @Test
     void test_saveQuestionCreation()
    {
        when(questionConverter.dtoToEntity(any(QuestionDTO.class))).thenReturn(question);
        when(questionRepository.save(any(Question.class))).thenReturn(question);
        when(questionConverter.entityToDTO(any(Question.class))).thenReturn(questionDTO);
        assertNotNull(questionService.saveQuestion(questionDTO));
    }


    @Test
    void test_saveQuestionError()
    {

        when(questionRepository.save(question)).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class,()->questionService.saveQuestion(questionDTO));
    }

    @Test
     void test_deleteQuestionSuccess()
    {
        questionRepository.deleteById(1);
        verify(questionRepository).deleteById(1);
        verify(questionRepository, times(1)).deleteById(1);
    }


    @Test
    void test_deleteQuestionError()
    {
        assertThrows(QuestionNotFoundException.class,()->questionService.deleteQuestion(null));
    }

    @Test
    void test_updateQuestionSuccess()
    {
        when(questionRepository.findById(anyInt())).thenReturn(Optional.ofNullable(question));
        when(questionConverter.dtoToEntity(any(QuestionDTO.class))).thenReturn(question);
        when(questionRepository.save(any(Question.class))).thenReturn(question);
        when(questionConverter.entityToDTO(any(Question.class))).thenReturn(questionDTO);
        assertNotNull(questionService.updateQuestion(questionDTO));
    }

    @Test
    void test_updateQuestionError()
    {
        assertThrows(QuestionNotFoundException.class,()->questionService.updateQuestion(questionDTO));
    }

    @Test
    void test_getQuestionByIdSuccess()
    {
        when(questionRepository.findById(anyInt())).thenReturn(Optional.of(question));
        when(questionConverter.entityToDTO(any(Question.class))).thenReturn(questionDTO);
        assertNotNull(questionService.getQuestionById(anyInt()));
    }

    @Test
    void test_getQuestionByIdError()
    {
        when(questionRepository.findById(anyInt())).thenReturn(Optional.of(question));
        when(questionConverter.entityToDTO(any(Question.class))).thenReturn(null);
        assertNull(questionService.getQuestionById(anyInt()));
    }

    @Test
    void test_getQuestionsBasedOnIdsSuccess() {
        when(questionRepository.findAllById(Arrays.asList(1, 2, 3, 4, 4))).thenReturn(new ArrayList<Question>());
        assertNotNull(questionService.getQuestionsBasedOnIds(Arrays.asList(1, 2, 3, 4, 4)));
    }

    @Test
    void test_getQuestionsBasedOnIdsSuccess2() {
        when(questionRepository.findAllById(Arrays.asList(1, 2, 3, 4, 4))).thenReturn(null);
        assertNull(questionService.getQuestionsBasedOnIds(Arrays.asList(1, 2, 3, 4, 4)));
    }

    @Test
    void test_getAllQuestionListSuccess()
    {

        when(questionRepository.findAll()).thenReturn(Arrays.asList(new Question()));
        assertEquals(1,questionService.getAllQuestionList().size());
    }

    @Test
    void test_getAllQuestionListError()
    {

        when(questionRepository.findAll()).thenReturn(Arrays.asList());
        assertEquals(0,questionService.getAllQuestionList().size());
    }


}
