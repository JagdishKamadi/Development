package com.epam.quiz.service;

import com.epam.quiz.dao.QuestionDao;
import com.epam.quiz.dao.QuestionDaoImpl;
import com.epam.quiz.model.Question;
import com.epam.quiz.model.QuestionTag;
import com.epam.quiz.service.QuestionValidationServiceImpl;
import com.epam.quiz.utility.enm.QuestionDifficultyTag;
import com.epam.quiz.utility.enm.QuestionTopicTag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QuestionValidationServiceImplTest {

    @Mock
    QuestionDaoImpl questionDaoImpl;

    @InjectMocks
    QuestionValidationServiceImpl questionValidationService;

    private List<Question> questionList;

    @BeforeEach
    public void setUpObject() {
        questionList = new ArrayList<>();
        QuestionTag questionTag1 = new QuestionTag(1, QuestionTopicTag.JAVA_FUNDAMENTALS, QuestionDifficultyTag.EASY);
        Question question = new Question("Which statement is true about Java?", "Java is a sequence-dependent programming language ", "Java is a code dependent programming language ", "Java is a platform-dependent programming language ", "Java is a platform-independent programming language", "D");
        question.setSectionName("CORE_JAVA");
        question.setQuestionTag(questionTag1);
        question.setQuestionId(12);
        questionList.add(question);
    }

    /**
     * checking for method addQuestionChecker
     * TO-LIST
     * 1) add the data and then check the size
     */

    @Test
    @DisplayName("Adding new question to database")
    void addQuestionCheckerTest() {
        QuestionTag questionTag2 = new QuestionTag(2, QuestionTopicTag.JAVA_FUNDAMENTALS, QuestionDifficultyTag.EASY);
        Question question2 = new Question("What is the extension of java code files?", ".txt", ".pdf", ".sql", ".java", "D");
        question2.setSectionName("CORE_JAVA");
        question2.setQuestionTag(questionTag2);

        questionDaoImpl.addNewQuestionToDB(question2);
        verify(questionDaoImpl).addNewQuestionToDB(question2);
        verify(questionDaoImpl, times(1)).addNewQuestionToDB(question2);
    }

    @Test
    @DisplayName("Adding new question to database")
    void deleteQuestionCheckerTest() {
        int questionNumber = 12;
        boolean result = true;
        when(questionValidationService.isQuestionNumberPresentChecker(anyInt())).thenReturn(result);
        questionDaoImpl.deleteQuestionFromDB(questionNumber);
        verify(questionDaoImpl).deleteQuestionFromDB(questionNumber);
        verify(questionDaoImpl, times(1)).deleteQuestionFromDB(questionNumber);
    }

    @Test
    @DisplayName("Updating  question from database")
    void updateQuestionCheckerTest() {
        int questionNumber = 12;
        QuestionTag questionTag2 = new QuestionTag(2, QuestionTopicTag.JAVA_FUNDAMENTALS, QuestionDifficultyTag.EASY);
        Question question2 = new Question("What is the extension of java code files?", ".txt", ".pdf", ".sql", ".java", "D");
        question2.setSectionName("CORE_JAVA");
        question2.setQuestionTag(questionTag2);

        when(questionDaoImpl.getAllQuestionList()).thenReturn(questionList);
        assertTrue(questionValidationService.isQuestionNumberPresentChecker(questionNumber));

        questionDaoImpl.updateQuestionFromDB(questionNumber, question2);

        verify(questionDaoImpl).updateQuestionFromDB(questionNumber, question2);
        verify(questionDaoImpl, times(1)).updateQuestionFromDB(questionNumber, question2);
    }

}
