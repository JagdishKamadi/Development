package com.epam.quiz.controller;

import com.epam.quiz.dto.QuestionDTO;
import com.epam.quiz.model.Section;
import com.epam.quiz.repository.QuestionRepository;
import com.epam.quiz.service.QuestionService;
import com.epam.quiz.utility.cls.DisplayTag;
import com.epam.quiz.utility.enm.DifficultyTag;
import com.epam.quiz.utility.enm.SectionTag;
import com.epam.quiz.utility.enm.TopicTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/quizupdate")
public class QuizUpdateController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private DisplayTag displayTag;
    @Autowired
    private QuestionRepository questionRepository;


    @GetMapping("/view")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView viewQuestion(@RequestParam("questionid") String questionId) {
        ModelAndView md = new ModelAndView();
        md.addObject("question", questionService.getQuestionById(Integer.parseInt(questionId)));
        md.setViewName("updatequiz/viewquestion");
        return md;
    }

    @GetMapping("/add")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView getQuestionAddPage() {
        ModelAndView md = new ModelAndView();
        md.addObject("sectionList", displayTag.getSectionList());
        md.addObject("topicList", displayTag.getTopicList());
        md.addObject("difficultyList", displayTag.getDifficultyList());
        md.setViewName("updatequiz/addnewquestion");
        return md;
    }

    @PostMapping("/savequestion")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView saveQuestion(QuestionDTO question,
                                     @RequestParam("sectionName") String sectionName,
                                     @RequestParam("topicName") String topicName,
                                     @RequestParam("difficultyName") String difficultyName) {


        Section section = new Section(TopicTag.valueOf(topicName), DifficultyTag.valueOf(difficultyName));
        question.setSection(section);
        question.setSectionTag(SectionTag.valueOf(sectionName));
        questionService.saveQuestion(question);
        ModelAndView md = new ModelAndView();
        md.addObject("questions", questionService.getAllQuestionList());
        md.setViewName("updatequiz/quizupdatepage");

        return md;
    }

    @GetMapping("/removequestion")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView removeQuestion(@RequestParam("questionid") String questionId) {
        ModelAndView md = new ModelAndView();
        questionService.deleteQuestion(Integer.parseInt(questionId));
        md.addObject("questions", questionService.getAllQuestionList());
        md.setViewName("updatequiz/quizupdatepage");
        return md;
    }



    @GetMapping("/edit")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView getQuestionUpdatePage(@RequestParam("questionid") String questionId) {
        ModelAndView md = new ModelAndView();
        md.addObject("updatequestion", questionService.getQuestionById(Integer.parseInt(questionId)));
        md.addObject("sectionList", displayTag.getSectionList());
        md.addObject("topicList", displayTag.getTopicList());
        md.addObject("difficultyList", displayTag.getDifficultyList());
        md.setViewName("updatequiz/updatequestion");
        return md;
    }

    @PostMapping("/updatequestion")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView updateQuestion(QuestionDTO questionDTO,
                                       @RequestParam("sectionName") String sectionName,
                                       @RequestParam("topicName") String topicName,
                                       @RequestParam("difficultyName") String difficultyName) {

        Section section = new Section(TopicTag.valueOf(topicName), DifficultyTag.valueOf(difficultyName));
        questionDTO.setSection(section);
        questionDTO.setSectionTag(SectionTag.valueOf(sectionName));
        questionService.saveQuestion(questionDTO);
        ModelAndView md = new ModelAndView();
        md.addObject("questions", questionService.getAllQuestionList());
        md.setViewName("updatequiz/quizupdatepage");
        return md;
    }

}
