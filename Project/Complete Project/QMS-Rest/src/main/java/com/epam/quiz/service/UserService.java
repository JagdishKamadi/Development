package com.epam.quiz.service;

import com.epam.quiz.dto.UserDTO;
import com.epam.quiz.model.User;

public interface UserService{
	 void userLogin(UserDTO userDTO);
	 void userAdded(UserDTO userDTO);
	 User getUser(String username);
}
