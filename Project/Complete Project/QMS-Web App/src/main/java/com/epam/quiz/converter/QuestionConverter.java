package com.epam.quiz.converter;

import com.epam.quiz.dto.QuestionDTO;
import com.epam.quiz.model.Question;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class QuestionConverter {

    public Question convertDTOToEntity(QuestionDTO questionDTO)
    {
        ModelMapper modelMapper = new  ModelMapper();
        return modelMapper.map(questionDTO,Question.class);
    }

    public QuestionDTO convertEntityToDTO(Question question)
    {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(question,QuestionDTO.class);
    }
}
