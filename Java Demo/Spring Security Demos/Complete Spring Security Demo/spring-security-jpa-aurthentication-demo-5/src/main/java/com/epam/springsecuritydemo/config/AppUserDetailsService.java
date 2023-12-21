package com.epam.springsecuritydemo.config;

import com.epam.springsecuritydemo.entity.User;
import com.epam.springsecuritydemo.exception.UserNotFoundException;
import com.epam.springsecuritydemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s).orElseThrow(()->new UserNotFoundException("User not found for username "+s));
        return new AppUserDetails(user);
    }
}
