package com.epam.quiz.controller;

import com.epam.quiz.model.Question;
import com.epam.quiz.service.CreateQuizService;
import com.epam.quiz.service.QuestionService;
import com.epam.quiz.service.QuestionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(QuizUpdateController.class)
class QuizUpdateControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private QuestionServiceImpl questionService;

	@InjectMocks
	private QuizUpdateController quizUpdateController;
	private Question question ;

	@BeforeEach
	public void setupObject()
	{
		question = new Question();
	}


    @Test
	 void saveQuestionTest() throws Exception
	{
		this.mockMvc.perform(post("/quizupdate/savequestion")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("questionid", "1")
				.param("questionDescription", "What is my name")
				.param("option1","Kamadi")
				.param("option2","Gawande")
				.param("option3","Bhoyar")
				.param("option4","Awari")
				.param("sectionName", "CORE_JAVA")
				.param("topicName", "ARRAY")
				.param("difficultyName", "EASY")
				)
                 .andExpect(view().name("adminpages/adminpage"));
	}

	@Test
	 void removeQuestionTest() throws Exception
	{
		when(questionService.isQuestionDeleted(anyInt())).thenReturn(true);
		this.mockMvc.perform(get("/quizupdate/removequestion").param("questionid", "78"))
        .andExpect(view().name("adminpages/adminpage"));
	}

	@Test
	 void checkUpdateQuestionNumberTest() throws Exception
	{
		Question question = new Question();
		when(questionService.isQuestionExist(anyInt())).thenReturn(true);
		when(questionService.getQuestionById(anyInt())).thenReturn(Optional.of(question));
		this.mockMvc.perform(get("/quizupdate/checkquestion").param("questionid", "78"))
        .andExpect(view().name("/updatequiz/updatequestion"));
	}

	@Test
	void updateQuestionTest() throws Exception
	{
		this.mockMvc.perform(post("/quizupdate/updatequestion")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.param("questionid", "1")
						.param("questionDescription", "What is my name")
						.param("option1","Kamadi")
						.param("option2","Gawande")
						.param("option3","Bhoyar")
						.param("option4","Awari")
						.param("sectionName", "CORE_JAVA")
						.param("topicName", "ARRAY")
						.param("difficultyName", "EASY")
				)
				.andExpect(view().name("adminpages/adminpage"));
	}

}
