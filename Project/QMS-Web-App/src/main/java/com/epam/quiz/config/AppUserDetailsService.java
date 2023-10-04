package com.epam.quiz.config;

import com.epam.quiz.model.AuthGroup;
import com.epam.quiz.model.User;
import com.epam.quiz.repository.AuthGroupRepository;
import com.epam.quiz.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppUserDetailsService implements UserDetailsService {


	private UserRepository userRepository;
	private AuthGroupRepository authGroupRepository;

	public AppUserDetailsService(UserRepository userRepository,AuthGroupRepository authGroupRepository)
	{
		super();
		this.userRepository = userRepository;
		this.authGroupRepository = authGroupRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (null == user) {
			throw new UsernameNotFoundException("Cannot find username :" + username);
		}

		List<AuthGroup> authorities = authGroupRepository.findByUsername(username);

		List<SimpleGrantedAuthority> simpleGrantedAuthorityList =  authorities
																	.stream()
																	.map(authGroup -> new SimpleGrantedAuthority(authGroup.getAuthGroup()))
																	.collect(Collectors.toList());

		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(),simpleGrantedAuthorityList);
	}

}
