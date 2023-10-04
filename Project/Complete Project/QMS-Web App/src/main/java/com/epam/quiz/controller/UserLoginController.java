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
@RequestMapping("/user")
public class UserLoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private SectionService sectionService;
    @Autowired
    private DisplayTag displayTag;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/userlogin")
    public String userLogin() {
        return "userpages/userlogin";
    }

    @GetMapping("/userregister")
    public String userRegister() {
        return "userpages/register";
    }

    @PostMapping("/getlogindetails")
    public ModelAndView getUserLoginDetails(HttpSession session, UserDTO userDTO) throws QuestionNotFoundException {

        userDTO.setTypeOfUser(2);
        boolean result = userService.isUserLogin(userDTO);
        if (!result) {
            throw new UserNotFoundException();
        }

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
        boolean result = userService.isAddedUser(userDTO);
        if (!result) {
            return "/userpages/userexistpage";
        }
        return "/userpages/userlogin";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "/quizpages/logoutpage";
    }

}
