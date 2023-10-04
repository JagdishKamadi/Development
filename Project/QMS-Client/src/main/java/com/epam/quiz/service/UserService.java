package com.epam.quiz.service;

import com.epam.quiz.dto.UserDTO;

public interface UserService{
	 boolean isUserLogin(UserDTO user);
	 boolean isAddedUser(UserDTO user);

}
