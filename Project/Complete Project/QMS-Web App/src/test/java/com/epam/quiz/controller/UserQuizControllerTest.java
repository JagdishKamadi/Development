package com.epam.quiz.controller;

import com.epam.quiz.model.Question;
import com.epam.quiz.model.Section;
import com.epam.quiz.service.CreateQuizServiceImpl;
import com.epam.quiz.service.QuestionService;
import com.epam.quiz.service.QuestionServiceImpl;
import com.epam.quiz.service.SectionService;
import com.epam.quiz.utility.enm.DifficultyTag;
import com.epam.quiz.utility.enm.SectionTag;
import com.epam.quiz.utility.enm.TopicTag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class UserQuizControllerTest {

	@Autowired
	private MockMvc mockMvc;

    @MockBean
    private SectionService sectionService;
	@MockBean
	private QuestionServiceImpl questionService;

	@MockBean
	private CreateQuizServiceImpl createQuizServiceImpl;



	@Test // for more than 3
	 void startQuizTest() throws Exception {
		when(sectionService.getSectionNameNumberList(anyString())).thenReturn(Arrays.asList(1,2,3,4,4,5));
		mockMvc.perform(post("/userquiz/startquiz").param("sectionname", "CORE_JAVA"))
				.andExpect(view().name("/quizpages/testpage"));
	}

	@Test // for less than 3
	 void startQuizTest2() throws Exception {
		when(sectionService.getSectionNameNumberList(anyString())).thenReturn(Arrays.asList(1,5));
		mockMvc.perform(post("/userquiz/startquiz").param("sectionname", "CORE_JAVA"))
				.andExpect(view().name("/sectionpages/sectionnotfoundpage"));

	}

	// if user will attend any question
	@Test
	 void getResultTest1() throws Exception {
		Section section1 = new Section(TopicTag.ARRAY, DifficultyTag.EASY);
		Section section2 = new Section(TopicTag.ARRAY, DifficultyTag.ADVANCE);

		Question question1 = new Question("What is My name","Jagdish","Tejas","Madhur","Jayant","A");
		Question question2 = new Question("What is My your name","Jagdish","Tejas","Madhur","Jayant","B");

		question1.setSectionTag(SectionTag.CORE_JAVA);
		question1.setSectionTag(SectionTag.ADVANCE_JAVA);

		question1.setSection(section1);
		question2.setSection(section2);

		when(questionService.getCustomQuestionList(Arrays.asList(1,2,4,54,5))).thenReturn(Arrays.asList(question1,question2));
		mockMvc.perform(get("/userquiz/submittest")
						.param("1","A")
						.param("2","B"))
				.andExpect(view().name("/quizpages/resultpage"));
	}

	// if user will not attend any question
	@Test
	 void getResultTest2() throws Exception {

		mockMvc.perform(get("/userquiz/submittest"))
				.andExpect(view().name("/quizpages/resultpage"));
	}

}

/* Completed all test cases */