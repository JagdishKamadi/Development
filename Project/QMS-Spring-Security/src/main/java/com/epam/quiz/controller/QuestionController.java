package com.epam.quiz.controller;

import com.epam.quiz.converter.QuestionConverter;
import com.epam.quiz.dto.QuestionDTO;
import com.epam.quiz.service.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuestionConverter questionConverter;


    @Operation(summary = "Get Single Question API")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Question shown successfully"), @ApiResponse(responseCode = "400", description = "Question doesn't exist")})

    @GetMapping("/{questionid}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<QuestionDTO> getQuestion(@Parameter(description = "required question id to get the question") @PathVariable("questionid") String questionId) {
        QuestionDTO questionDTO = questionService.getQuestionById(Integer.parseInt(questionId));

        return new ResponseEntity<>(questionDTO, HttpStatus.OK);
    }

    @Operation(summary = "Get All Question API")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Questions shown successfully"), @ApiResponse(responseCode = "400", description = "Questions doesn't exist")})
    // for showing the all data
    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<QuestionDTO>> getQuestions() {
        return new ResponseEntity<>(questionService.getAllQuestionList(), HttpStatus.OK);
    }

    @Operation(summary = "Question Save API")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Question saved Successfully", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = QuestionDTO.class))}), @ApiResponse(responseCode = "400", description = "Bad request!")})
    // for saving one question
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<QuestionDTO> save(@RequestBody QuestionDTO questionDTO) {
        return new ResponseEntity<>(questionService.saveQuestion(questionDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Question Delete API")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Question deleted successfully"), @ApiResponse(responseCode = "400", description = "Bad request!")})
    // for deleting question
    @DeleteMapping("/{questionid}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> delete(@Parameter(description = "required question id to delete the question") @PathVariable("questionid") String questionId) {
        questionService.deleteQuestion(Integer.parseInt(questionId));
        return new ResponseEntity<>("Question deleted successfully", HttpStatus.OK);
    }

    @Operation(summary = "Question Update API")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Question updated Successfully", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = QuestionDTO.class))}), @ApiResponse(responseCode = "400", description = "Bad request!")})

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<QuestionDTO> update(@RequestBody QuestionDTO questionDTO) {

        QuestionDTO questionDTO1 = questionService.updateQuestion(questionDTO);
        return new ResponseEntity<>(questionDTO1, HttpStatus.OK);
    }
}
