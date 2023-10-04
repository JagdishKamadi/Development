package com.epam.quiz.controller;

import com.epam.quiz.model.Question;
import com.epam.quiz.service.CreateQuizServiceImpl;
import com.epam.quiz.service.QuestionValidationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/userquiz")
public class UserQuizController {
	
	@Autowired
	private CreateQuizServiceImpl createQuizServiceImpl;
	

	@Autowired
	private QuestionValidationServiceImpl questionValidationServiceImpl;
	
	
	@PostMapping("/startquiz")
	public ModelAndView startQuiz(@RequestParam("sectionname") String sectionName)
	{
		ModelAndView md = new ModelAndView();
		md.addObject("sectionname",sectionName);
		
		int size = questionValidationServiceImpl.getCountBySectionName(sectionName);

		if(size>0)
		{
			md.addObject("quizsection",createQuizServiceImpl.getQuestionNumberListBySectionName(sectionName));
			System.out.println(createQuizServiceImpl.getQuestionNumberListBySectionName(sectionName));
			md.setViewName( "/quizpages/testpage");
		}
		else
		{
			md.setViewName("/sectionpages/sectionnotfoundpage");
		}
		
		return md;
	}
	
	@RequestMapping(value = "/submittest")
	public ModelAndView   getResult(@RequestParam Map<String,String> answerMap)
	{
		int score = 0;
		ModelAndView md = new ModelAndView();
		md.setViewName("/quizpages/resultpage");
		
		
		if(answerMap.size()==0)
		{
			md.addObject("score",score);
			return md;
		
		}
		else
		{
			Set<Integer> questionNumber = answerMap
					.keySet()
					.stream()
					.map(Integer::parseInt)
					.collect(Collectors.toSet());
			
			List<Question> questionList = createQuizServiceImpl.getQuestionListById(questionNumber);
			
			for(Question question : questionList)
			{
				if(answerMap.containsKey(String.valueOf(question.getQuestionId())))
				{
					if(answerMap.get(String.valueOf(question.getQuestionId())).equals(question.getAnswer()))
					{
						if(question.getQuestionTag().getQuestionDifficultyTag().equals("ADVANCE"))
						{
							score+=2;
						}
						else {
							score++;
						}
					}
				}	
			}
			
			md.addObject("sectionname",questionList.get(0).getSectionName());
			md.addObject("score",score);

		}
		
	 return md;
	}
	
}
