package com.epam.quiz.controller;

import com.epam.quiz.model.Question;
import com.epam.quiz.service.CreateQuizService;
import com.epam.quiz.service.QuestionService;
import com.epam.quiz.service.SectionService;
import com.epam.quiz.utility.cls.ScoreCalculator;
import com.epam.quiz.utility.enm.SectionTag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user_quizzes")
public class UserQuizController {

    @Autowired
    private CreateQuizService createQuizService;
    @Autowired
    private QuestionService questionService;

    @Autowired
    private SectionService sectionService;

    @Operation(summary = "User Quiz API")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful response got"), @ApiResponse(responseCode = "400", description = "Bad request!")})
    @PostMapping(path = "/start_quiz/{section_name}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<List<Question>> startQuiz(@Parameter(description = "section name to get the section quiz") @PathVariable("section_name") String sectionName) {
        return new ResponseEntity<>(createQuizService.createQuestionListBySectionName(sectionName), HttpStatus.OK);
    }

    @Operation(summary = "User Result API")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Test submitted successfully"), @ApiResponse(responseCode = "400", description = "Bad request!")})
    @PostMapping(value = "/submit")
    @PreAuthorize("permitAll()")
    public ResponseEntity<Integer> getResult(@RequestParam Map<String, String> answerMap) {
        int score=0;

        if (answerMap.size() != 0) {
            List<Question> questionList = questionService.getQuestionsBasedOnIds(ScoreCalculator.getQuestionIdList(answerMap));
            score = ScoreCalculator.totalScore(questionList, answerMap);
        }
        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
