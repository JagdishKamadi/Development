package com.epam.quiz.config;

import com.epam.quiz.model.AuthGroup;
import com.epam.quiz.model.User;
import com.epam.quiz.repository.AuthGroupRepository;
import com.epam.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    private final AuthGroupRepository authGroupRepository;

    public AppUserDetailsService(UserRepository repository, AuthGroupRepository authGroupRepository) {
        super();
        this.userRepository = repository;
        this.authGroupRepository = authGroupRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (null == user) {
            throw new UsernameNotFoundException("Cannot find username :" + username);
        }

        List<AuthGroup> authorties = authGroupRepository.findByUsername(username);

        org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(),
                authorties.stream().map(authGroup -> new SimpleGrantedAuthority(authGroup.getAuthGroup()))
                        .collect(Collectors.toList()));
        return userDetails;
    }

}

