package com.epam.quiz.controller;

import com.epam.quiz.dto.UserDTO;
import com.epam.quiz.exception.QuestionNotFoundException;
import com.epam.quiz.exception.UserNotFoundException;
import com.epam.quiz.service.QuestionService;
import com.epam.quiz.service.SectionService;
import com.epam.quiz.service.UserService;
import com.epam.quiz.utility.cls.DisplayTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserLoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private SectionService sectionService;
    @Autowired
    private DisplayTag displayTag;
    @Autowired
    private QuestionService questionService;



    @GetMapping("/register")
    public String userRegister() {
        return "userpages/registerpage";
    }

    @GetMapping("/login")
    public ModelAndView getUserLoginDetails() throws QuestionNotFoundException {
        ModelAndView md = new ModelAndView();
        md.addObject("sectionlist",displayTag.getSectionList());
        md.setViewName("/quizpages/showquiz");
        return md;
    }

    @PostMapping("/registerdetails")
    public String getUserRegisterDetails(UserDTO userDTO) {
        userDTO.setTypeOfUser(2);
        userService.userAdded(userDTO);
        return "/userpages/userlogin";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "/quizpages/logoutpage";
    }

}
