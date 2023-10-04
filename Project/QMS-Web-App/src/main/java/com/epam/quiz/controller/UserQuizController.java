package com.epam.quiz.controller;

import com.epam.quiz.model.Question;
import com.epam.quiz.service.CreateQuizService;
import com.epam.quiz.service.QuestionServiceImpl;
import com.epam.quiz.service.SectionService;
import com.epam.quiz.utility.enm.SectionTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/userquiz")
public class UserQuizController {

	@Autowired
	private CreateQuizService createQuizService;
	@Autowired
	private QuestionServiceImpl questionService;

	@Autowired
	private SectionService sectionService;

	@PostMapping("/startquiz")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	public ModelAndView startQuiz(HttpServletRequest request, @RequestParam("sectionname") String sectionName) {
		ModelAndView md = new ModelAndView();
		md.addObject("sectionname", sectionName);


			int size = sectionService.getSectionQuestionIDList(String.valueOf(SectionTag.valueOf(sectionName))).size();

			if (size >= 3) {
				md.addObject("quizsection", createQuizService.createQuestionListBySectionName(sectionName));

				md.setViewName("/quizpages/testpage");
			} else {
				md.setViewName("/sectionpages/sectionnotfoundpage");
			}

		return md;
	}

	@GetMapping(value = "/submit")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	public ModelAndView getResult(@RequestParam Map<String, String> answerMap) {

		int score = 0;
		ModelAndView md = new ModelAndView();
		md.setViewName("/quizpages/resultpage");
		if (answerMap.size() == 0) {
			md.addObject("score", score);
			return md;

		} else {
			List<Question> questionList = questionService.getQuestionsBasedOnIds(getQuestionIdList(answerMap));
			score = totalScore(questionList,answerMap);
			md.setViewName("/quizpages/resultpage");
			md.addObject("score", score);
		}
		return md;
	}

	public List<Integer> getQuestionIdList(Map<String, String> answerMap) {
		return answerMap
				.keySet()
				.stream()
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

	public int getScore(SectionTag sectionTag) {
		String assumeLevel = sectionTag.toString().toUpperCase();
		return assumeLevel.equalsIgnoreCase("ADVANCE") ? 2 : 1;
	}

	public int totalScore(List<Question> questionList, Map<String, String> answerMap) {
		int score = 0;
		for (Question question : questionList) {
			if (answerMap.containsKey(String.valueOf(question.getQuestionId()))
					&& answerMap.get(String.valueOf(question.getQuestionId())).equals(question.getAnswer())) {
				score += getScore(question.getSectionTag());
			}

		}
		return score;
	}
}
