package com.epam.quiz.controller;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.quiz.model.Question;
import com.epam.quiz.service.CreateQuizServiceImpl;
import com.epam.quiz.service.QuestionValidationServiceImpl;
import com.epam.quiz.service.SectionValidationServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
class QuizUpdateControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private SectionValidationServiceImpl sectionValidationServiceImpl;
	
	@MockBean
	private CreateQuizServiceImpl createQuizServiceImpl;
	
	@MockBean
	private QuestionValidationServiceImpl questionValidationServiceImpl;
	
	@Autowired
	private SectionTagList sectionTagList;
	
	@InjectMocks
	private QuizUpdateController quizUpdateController;
	
	
//	@Test
//	public void saveQuestionTest() throws Exception
//	{
//	
//		mockMvc.perform(post("/quizupdate/savequestion"))
//		.andExpect(view().name("adminpages/adminpage"));
//	}
	
	@Test
	public void removeQuestionTest() throws Exception
	{
		when(questionValidationServiceImpl.deleteQuestionChecker(anyInt())).thenReturn(true);
		this.mockMvc.perform(get("/quizupdate/removequestion").param("questionid", "78"))
        .andExpect(view().name("adminpages/adminpage"));	
	}
	
	
	
	@Test
	public void checkUpdateQuestionNumberTest() throws Exception
	{
		this.mockMvc.perform(get("/quizupdate/checkquestion").param("questionid", "78"))
        .andExpect(view().name("/updatequiz/updatequestion"));
	}
	
//	@Test
//	public void updateQuestionTest1() throws Exception
//	{
//		this.mockMvc.perform(post("/quizupdate/updatequestion"))
//                 .andExpect(view().name("adminpages/adminpage"));
//	}
//	
//	@Test
//	public void updateQuestionTest() throws Exception
//	{
//		this.mockMvc.perform(post("/quizupdate/updatequestion")
//				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
//				.param("questionid", "1")
//				.param("questionDescription", "What is my name")
//				.param("option1","Kamadi")
//				.param("option2","Gawande")
//				.param("option3","Bhoyar")
//				.param("option4","Awari")
//				.param("sectionName", "CORE_JAVA")
//				.param("questiontopic", "ARRAY")
//				.param("questiondifficulty", "easy")
//				)
//                 .andExpect(view().name("adminpages/adminpage"));
//	}
//	
	
	
	@Test
	public void getSectionPageTest() throws Exception
	{
		this.mockMvc.perform(get("/quizupdate/getsectionpage").param("sectionname", "CORE_JAVA"))
        .andExpect(view().name("/sectionpages/sectionpage"));
	}
}
