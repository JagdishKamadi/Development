package org.epam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Teacher {

    @Autowired
    @Qualifier("scienceTeacherBean")
    private ScienceTeacher scienceTeacher;

    public void show() {
        System.out.println("Hello World");
        scienceTeacher.showScienceTeacherName();
    }
}
