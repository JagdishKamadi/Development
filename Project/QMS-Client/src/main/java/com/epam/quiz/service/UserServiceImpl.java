package com.epam.quiz.service;

import com.epam.quiz.converter.UserConverter;
import com.epam.quiz.dto.UserDTO;
import com.epam.quiz.model.User;
import com.epam.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserConverter userConverter;

	public boolean isUserLogin(UserDTO user) {

		return userRepository
				.findByUsernameAndPasswordAndTypeOfUser(user.getUsername(), user.getPassword(),user.getTypeOfUser())
				.isPresent();
	}
				

	public boolean isAddedUser(UserDTO userDTO) {
		boolean flag=true;
		if (userRepository.findByUsernameOrMailid(userDTO.getUsername(), userDTO.getMailId()) >= 1) {
			flag =  false;
		}

		User user = userConverter.convertDTOToEntity(userDTO);
		userRepository.save(user);
		return flag;
	}

}
