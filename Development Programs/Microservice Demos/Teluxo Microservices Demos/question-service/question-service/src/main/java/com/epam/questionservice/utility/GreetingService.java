package com.epam.questionservice.utility;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component(value = "greeting")
public class GreetingService {

    @Value("${server.port:8080}")
    private String portNumber;

    @Value("${user.name:Admin}")
    private String userName;

    public void welcomeUser() {
        log.info(String.format("Welcome %s, Application has been started at port number %s.", userName, portNumber));
    }
}
