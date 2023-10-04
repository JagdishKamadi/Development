package com.epam.quiz.service;

import com.epam.quiz.converter.QuestionConverter;
import com.epam.quiz.dto.QuestionDTO;
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
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

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
     void saveQuestionPassTest()
    {
        when(questionConverter.convertDTOToEntity(questionDTO)).thenReturn(question);
        when(questionRepository.save(question)).thenReturn(question);
        assertNotNull(questionService.saveQuestion(questionDTO));
    }

    @Test
    void saveQuestionFailTest1()
    {
        when(questionConverter.convertDTOToEntity(questionDTO)).thenReturn(question);
        when(questionRepository.save(question)).thenReturn(null);
        assertNull(questionService.saveQuestion(questionDTO));
    }

    @Test
    void saveQuestionFailTest2()
    {

        when(questionRepository.save(question)).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class,()->questionService.saveQuestion(questionDTO));
    }

    @Test
     void isQuestionDeletedPassTest()
    {
        when(questionRepository.existsById(anyInt())).thenReturn(true);
        assertTrue(questionService.isQuestionDeleted(anyInt()));
    }

    @Test
     void isQuestionDeletedFailTest()
    {
        when(questionRepository.existsById(anyInt())).thenReturn(false);
        assertFalse(questionService.isQuestionDeleted(anyInt()));
    }

    @Test
    void isQuestionUpdatedPassTest()
    {

        when(questionRepository.existsById(anyInt())).thenReturn(true);
        assertTrue(questionService.isQuestionUpdated(questionDTO));
    }

    @Test
    void isQuestionUpdatedFailTest()
    {

        when(questionRepository.existsById(anyInt())).thenReturn(false);
        assertFalse(questionService.isQuestionUpdated(questionDTO));
    }

    @Test
    void getQuestionByIdPassTest()
    {
        when(questionRepository.findById(anyInt())).thenReturn(Optional.of(question));
        assertNotNull(questionService.getQuestionById(anyInt()));
    }

    @Test
    void getQuestionByIdFailTest()
    {
        when(questionRepository.findById(anyInt())).thenReturn(Optional.empty());
        assertEquals(Optional.empty(),questionService.getQuestionById(anyInt()));
    }

    @Test
    void getCustomQuestionListPassTest() {
        when(questionRepository.findAllById(Arrays.asList(1, 2, 3, 4, 4))).thenReturn(new ArrayList<Question>());
        assertNotNull(questionService.getCustomQuestionList(Arrays.asList(1, 2, 3, 4, 4)));
    }

    @Test
    void getCustomQuestionListFailTest() {
        when(questionRepository.findAllById(Arrays.asList(1, 2, 3, 4, 4))).thenReturn(null);
        assertNull(questionService.getCustomQuestionList(Arrays.asList(1, 2, 3, 4, 4)));
    }

    @Test
    void getAllQuestionListPassTest()
    {

        when(questionRepository.findAll()).thenReturn(Arrays.asList(new Question()));
        assertEquals(1,questionService.getAllQuestionList().size());
    }

    @Test
    void getAllQuestionListFailTest()
    {

        when(questionRepository.findAll()).thenReturn(Arrays.asList());
        assertEquals(0,questionService.getAllQuestionList().size());
    }

    @Test
    void isQuestionExistPassTest()
    {
        when(questionRepository.existsById(anyInt())).thenReturn(true);
        assertTrue(questionService.isQuestionExist(anyInt()));
    }

    @Test
    void isQuestionExistFailTest()
    {
        when(questionRepository.existsById(anyInt())).thenReturn(false);
        assertFalse(questionService.isQuestionExist(anyInt()));
    }
}
