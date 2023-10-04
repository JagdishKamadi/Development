package com.epam.quiz.service;

import com.epam.quiz.converter.UserConverter;
import com.epam.quiz.dto.UserDTO;
import com.epam.quiz.exception.UserExistException;
import com.epam.quiz.exception.UserNotFoundException;
import com.epam.quiz.model.AuthGroup;
import com.epam.quiz.model.User;
import com.epam.quiz.repository.AuthGroupRepository;
import com.epam.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthGroupRepository authGroupRepository;

	@Autowired
	private UserConverter userConverter;

	public void userLogin(UserDTO userDTO) {
		userRepository
				.findByUsernameAndPasswordAndTypeOfUser(userDTO.getUsername(), userDTO.getPassword(),userDTO.getTypeOfUser())
				.orElseThrow(UserNotFoundException::new);
	}

	public void userAdded(UserDTO userDTO) {
		if(userRepository.findByUsernameOrMailid(userDTO.getUsername(), userDTO.getMailId())>=1)
		{
			throw new UserExistException();
		}

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		AuthGroup authGroup = new AuthGroup();
		authGroup.setAuthGroup("USER");
		authGroup.setUsername(userDTO.getUsername());
		authGroupRepository.save(authGroup);
		userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
		userRepository.save(userConverter.dtoToEntity(userDTO));
	}

}
