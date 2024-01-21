package com.epam.service;

import com.epam.exception.UserNotFoundException;
import com.epam.repository.UserRepository;
import com.epam.valueobject.Department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.model.*;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseTemplateVO getUserWithDepartment(Integer userId) {
        log.info("Inside getUserWithDepartment pass : 1");
        User user = userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("User not found for id "+userId));

        log.info("Inside getUserWithDepartment pass : 2");
        log.info(String.valueOf(user));
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);

        log.info("Inside getUserWithDepartment pass : 3");
        log.info(String.valueOf(department));
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);
        return responseTemplateVO;
    }
}
