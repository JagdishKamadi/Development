package com.epam.quiz.service;

import com.epam.quiz.converter.QuestionConverter;
import com.epam.quiz.dto.QuestionDTO;
import com.epam.quiz.exception.QuestionNotFoundException;
import com.epam.quiz.model.Question;
import com.epam.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionConverter questionConverter;
    public QuestionDTO saveQuestion(QuestionDTO questionDTO) {

        Question question = questionConverter.dtoToEntity(questionDTO);
        return questionConverter.entityToDTO(questionRepository.save(question));
    }

    public void deleteQuestion(Integer questionId)
    {
        questionRepository
                .findById(questionId)
                .orElseThrow(() -> new QuestionNotFoundException("Question not found for id " + questionId));
        questionRepository.deleteById(questionId);
    }

    public QuestionDTO updateQuestion(QuestionDTO questionDTO) {
        Question question = questionRepository
                .findById(questionDTO.getQuestionId())
                .orElseThrow(()->new QuestionNotFoundException("Question not found for id "+questionDTO.getQuestionId()));
        question = questionConverter.dtoToEntity(questionDTO);
        return questionConverter.entityToDTO(questionRepository.save(question));
    }

    public QuestionDTO getQuestionById(final Integer questionId) {
        Question question = questionRepository.findById(questionId).orElseThrow(()->new QuestionNotFoundException("Question not found for this id "+questionId));
        return  questionConverter.entityToDTO(question);
    }

    public List<Question> getQuestionsBasedOnIds(List<Integer> questionIdList)
    {
        return questionRepository.findAllById(questionIdList);
    }
    public List<Question> getAllQuestionList() {
        return questionRepository.findAll();
    }
    }


