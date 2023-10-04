package com.epam.converter;

import com.epam.dto.UserDTO;
import com.epam.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    private ModelMapper modelMapper;

    public User dtoTOEntity(UserDTO userDTO)
    {
        modelMapper = new ModelMapper();
        return modelMapper.map(userDTO, User.class);
    }

    public UserDTO entityToDTO(User user)
    {
        modelMapper = new ModelMapper();
        return modelMapper.map(user,UserDTO.class);
    }
}
