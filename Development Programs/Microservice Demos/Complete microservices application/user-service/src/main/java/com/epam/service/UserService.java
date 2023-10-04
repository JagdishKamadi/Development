package com.epam.service;

import com.epam.model.*;

public interface UserService {

    User saveUser(User user);

    ResponseTemplateVO getUserWithDepartment(Integer userId);
}
