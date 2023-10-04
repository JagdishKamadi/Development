package com.epam.quiz.service;

import com.epam.quiz.converter.QuestionConverter;
import com.epam.quiz.dto.QuestionDTO;
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

    public Question saveQuestion(QuestionDTO questionDTO) {

        Question question = questionConverter.convertDTOToEntity(questionDTO);
        return questionRepository.save(question);
    }

    public boolean isQuestionDeleted(Integer questionId) {
        boolean result = questionRepository.existsById(questionId);
        if (result) {
            questionRepository.deleteById(questionId);
        }
        return result;
    }

    public boolean isQuestionUpdated(QuestionDTO questionDTO) {
        boolean result = questionRepository.existsById(questionDTO.getQuestionId());
        if (result) {
            Question question = questionConverter.convertDTOToEntity(questionDTO);
            questionRepository.save(question);
        }
        return result;
    }

    public Optional<Question> getQuestionById(final Integer questionId) {
        return questionRepository.findById(questionId);
    }

    public List<Question> getCustomQuestionList(List<Integer> questionIdList)
    {
        return questionRepository.findAllById(questionIdList);
    }
    public List<Question> getAllQuestionList() {
        return questionRepository.findAll();
    }

    public boolean isQuestionExist(final Integer questionId) {
        return questionRepository.existsById(questionId);
    }

}
