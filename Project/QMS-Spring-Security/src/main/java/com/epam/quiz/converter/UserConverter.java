package com.epam.quiz.converter;

import com.epam.quiz.dto.UserDTO;
import com.epam.quiz.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User dtoToEntity(UserDTO userDTO)
    {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userDTO,User.class);
    }

    public UserDTO entityToDTO(User user)
    {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, UserDTO.class);
    }
}
