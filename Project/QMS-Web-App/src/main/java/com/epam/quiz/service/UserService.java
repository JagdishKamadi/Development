package com.epam.quiz.service;

import com.epam.quiz.dto.UserDTO;

public interface UserService{
	void userLogin(UserDTO userDTO);
	void userAdded(UserDTO userDTO);
}
