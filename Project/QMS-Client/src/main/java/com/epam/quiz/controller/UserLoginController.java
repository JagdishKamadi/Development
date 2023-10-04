package com.epam.quiz.controller;

import com.epam.quiz.dto.UserDTO;
import com.epam.quiz.exception.QuestionNotFoundException;
import com.epam.quiz.exception.UserNotFoundException;
import com.epam.quiz.model.User;
import com.epam.quiz.service.QuestionService;
import com.epam.quiz.service.SectionService;
import com.epam.quiz.service.UserService;
import com.epam.quiz.utility.cls.DisplayTag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class UserLoginController {


    private static final Logger logger = LogManager.getLogger(UserLoginController.class);
    WebClient webClient;
    @Autowired
    private UserService userService;
    @Autowired
    private SectionService sectionService;
    @Autowired
    private DisplayTag displayTag;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/login")
    public String userLogin() {
        return "userpages/userlogin";
    }

    @GetMapping("/register")
    public String userRegister() {
        return "userpages/register";
    }

    @PostConstruct
    public void init() {
        webClient = WebClient.builder().baseUrl("http://localhost:9090/users")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
    }


    @PostMapping("/getlogindetails")
    public ModelAndView getUserLoginDetails(HttpSession session, UserDTO userDTO) throws QuestionNotFoundException {

        userDTO.setTypeOfUser(2);
        boolean result = userService.isUserLogin(userDTO);
        if (!result) {
            throw new UserNotFoundException();
        }

        webClient.post().uri("/login").bodyValue(userDTO).retrieve().bodyToMono(String.class).block();

        session.setAttribute("USERNAME",userDTO.getUsername());
        ModelAndView md = new ModelAndView();
        md.addObject("username", userDTO.getUsername());
        md.addObject("sectionlist",displayTag.getSectionList());
        md.setViewName("/quizpages/showquiz");

        return md;
    }




    @PostMapping("/getregisterdetails")
    public String getUserRegisterDetails(UserDTO userDTO) {
        userDTO.setTypeOfUser(2);

        webClient.post().uri("/register").bodyValue(userDTO).retrieve().bodyToMono(String.class).block();

       return "/userpages/userlogin";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "/quizpages/logoutpage";
    }

}
