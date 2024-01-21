package com.epam.service;
import com.epam.model.*;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUser(String username);

    List<User> getAllUser();
}
