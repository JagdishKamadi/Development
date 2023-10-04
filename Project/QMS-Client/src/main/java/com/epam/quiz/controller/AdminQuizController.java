package com.epam.quiz.controller;

import com.epam.quiz.service.QuestionService;
import com.epam.quiz.utility.cls.DisplayTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/adminquiz")
public class AdminQuizController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private DisplayTag displayTag;
    private WebClient webClient;
    @PostConstruct
    public void init() {
        webClient = WebClient.builder().baseUrl("http://localhost:9090/admin_quizzes")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
    }

    @GetMapping("/operation")
    public ModelAndView quizOperation(@RequestParam("optionchoice") String choice)  {

        ModelAndView md = new ModelAndView();

        md.addObject("sectionList",displayTag.getSectionList());
        md.addObject("topicList",displayTag.getTopicList());
        md.addObject("difficultyList",displayTag.getDifficultyList());
        md.addObject("questionList",questionService.getAllQuestionList());

        md.setViewName(getPageBasedOnChoice(Integer.parseInt(choice)));

        webClient.post().uri("/operation/{option_choice}",choice).bodyValue(choice).retrieve().bodyToMono(String.class).block();
        return md;
    }

    private String getPageBasedOnChoice(final Integer choice) {

        Map<Integer, String> pageMap = new HashMap<>();
        pageMap.put(1, "updatequiz/addnewquestion");
        pageMap.put(2, "updatequiz/removequestion");
        pageMap.put(3, "updatequiz/updatequestionchecker");
        pageMap.put(4, "updatequiz/showquestion");
        return pageMap.get(choice);
    }
}
