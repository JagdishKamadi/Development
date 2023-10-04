package com.epam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {

    @RequestMapping(value = "/employees")
    @ResponseBody
    public String getEmployees()
    {
        return "I am giving all employees";
    }
}

// to remove this we have rest controller
