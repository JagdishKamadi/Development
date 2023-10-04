package com.epam.quiz.controller;

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
import org.springframework.test.web.servlet.MockMvc;

import com.epam.quiz.service.CreateQuizServiceImpl;
import com.epam.quiz.service.QuestionValidationServiceImpl;
import com.epam.quiz.service.SectionValidationServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
class SectionUpdateControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	private SectionValidationServiceImpl sectionValidationServiceImpl;

	@InjectMocks
	private SectionUpdateController sectionUpdateController;

	@Test
	public void saveSectionTest() throws Exception {
		this.mockMvc.perform(post("/sectionupdate/savesection").param("sectionname", "NewSection"))
				.andExpect(view().name("adminpages/adminpage"));
	}

	@Test
	public void checkSectionTest() throws Exception {
		when(sectionValidationServiceImpl.isSectionTagExistChecker("CORE_JAVA")).thenReturn(true);
		this.mockMvc.perform(post("/sectionupdate/checksection").param("oldsectionname", "CORE_JAVA"))
				.andExpect(view().name("/updatequiz/updatesectiontag"));
	}

	@Test
	public void updateSectionTest() throws Exception {
		this.mockMvc.perform(post("/sectionupdate/updatesection").param("oldsectionname", "CORE_JAVA")
				.param("newsectionname", "DATEANDTIMEAPI")).andExpect(view().name("adminpages/adminpage"));
	}
}

/* Completed all test cases */