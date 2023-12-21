package com.epam.springdatajpademo1;

import com.epam.cls.QuestionDifficultyTag;
import com.epam.cls.QuestionTopicTag;
import com.epam.model.Question;
import com.epam.model.QuestionTag;
import com.epam.service.QuestionService;
import com.epam.service.QuestionServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


public class SpringDataJpaDemo1Application {

	public static void main(String[] args) {
//		ApplicationContext context = SpringApplication.run(SpringDataJpaDemo1Application.class, args);

		QuestionTag questionTag = new QuestionTag(QuestionTopicTag.COLLECTION,QuestionDifficultyTag.EASY);
		Question question = new Question("What is my name ","Jagdish","Madhur","Harshal","Tejas","A");
		question.setSectionName("Core_Java");
		question.setQuestionTag(questionTag);

		QuestionService service = new QuestionServiceImpl();
//		QuestionService service = context.getBean(QuestionServiceImpl.class);
		service.addQuestion(question);

	}

}
