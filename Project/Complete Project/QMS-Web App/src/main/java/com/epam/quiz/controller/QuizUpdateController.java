package com.epam.quiz.controller;

import com.epam.quiz.dto.QuestionDTO;
import com.epam.quiz.exception.QuestionNotFoundException;
import com.epam.quiz.model.Question;
import com.epam.quiz.model.Section;
import com.epam.quiz.repository.QuestionRepository;
import com.epam.quiz.service.QuestionService;
import com.epam.quiz.utility.cls.DisplayTag;
import com.epam.quiz.utility.enm.DifficultyTag;
import com.epam.quiz.utility.enm.SectionTag;
import com.epam.quiz.utility.enm.TopicTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/quizupdate")
public class QuizUpdateController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private DisplayTag displayTag;
    @Autowired
    private QuestionRepository questionRepository;
    private static final String ADMINPAGE = "adminpages/adminpage";

    @PostMapping("/savequestion")
    public ModelAndView saveQuestion(QuestionDTO question,
                                     @RequestParam("sectionName") String sectionName,
                                     @RequestParam("topicName") String topicName,
                                     @RequestParam("difficultyName") String difficultyName) {
    
    	
        Section section = new Section(TopicTag.valueOf(topicName), DifficultyTag.valueOf(difficultyName));
        question.setSection(section);
        question.setSectionTag(SectionTag.valueOf(sectionName));
        questionService.saveQuestion(question);
        ModelAndView md = new ModelAndView();

        md.setViewName(ADMINPAGE);

        return md;
    }

    @GetMapping("/removequestion")
    public String removeQuestion(@RequestParam("questionid") String questionId) {
        boolean result = questionService.isQuestionDeleted(Integer.parseInt(questionId));
        if (!result) {
            throw new QuestionNotFoundException();
        }

        return ADMINPAGE;
    }


    @GetMapping("/checkquestion")
    public String checkUpdateQuestionNumber(@RequestParam("questionid") String questionId, Model model) throws QuestionNotFoundException {

        boolean result = questionService.isQuestionExist(Integer.parseInt(questionId));
        if (!result) {
            throw new QuestionNotFoundException();
        }

        Question question = questionService.getQuestionById(Integer.parseInt(questionId)).orElseThrow(QuestionNotFoundException::new);
        model.addAttribute("questionid", questionId);
        model.addAttribute("question", question);
        model.addAttribute("sectionList",displayTag.getSectionList());
        model.addAttribute("topicList",displayTag.getTopicList());
        model.addAttribute("difficultyList",displayTag.getDifficultyList());

        return "/updatequiz/updatequestion";
    }


    @PostMapping("/updatequestion")
    public ModelAndView updateQuestion(QuestionDTO questionDTO,
                                       @RequestParam("sectionName") String sectionName,
                                       @RequestParam("topicName") String topicName,
                                       @RequestParam("difficultyName") String difficultyName) {

        Section section = new Section(TopicTag.valueOf(topicName),DifficultyTag.valueOf(difficultyName));
        questionDTO.setSection(section);
        questionDTO.setSectionTag(SectionTag.valueOf(sectionName));

        questionService.isQuestionUpdated(questionDTO);

        ModelAndView md = new ModelAndView();
        md.setViewName(ADMINPAGE);

        return md;
    }

}
