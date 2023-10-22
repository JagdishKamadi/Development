package com.epam.annotation_using_java_based_mixed;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class College {
    private static final Logger LOGGER = LogManager.getLogger(College.class);

    @Value("BIT")
    private String collegeName;

    /**
     * Here are the all example of dependencies injection
     * 1) using property
     * 2) using setter
     * 3) using constructor
     * 4) using @Qualifier annotation
     */

    // 1) using property
    @Autowired // here the primary bean should take by default:historyTeacher
    private Teacher historyTeacherBean;
    @Autowired
    private Teacher mathTeacherBean;
    private Teacher scienceTeacherBean;

    /**
     * we are using here the @Qualifier annotation
     * make sure to use the @Autowired annotation
     */
    @Autowired
    @Qualifier("englishTeacher")
    private Teacher englishTeacherBean;

    // 2) using setter
    @Autowired
    public void setMathTeacherBean(Teacher teacher) {
        mathTeacherBean = new MathTeacher();
    }


    // 3) using constructor
    @Autowired
    public College(Teacher teacher) {
        scienceTeacherBean = new ScienceTeacher();
    }

    public void sayHelloToStudent() {
        LOGGER.info("Hi Student, Welcome to the " + collegeName);
        LOGGER.info(historyTeacherBean);
        LOGGER.info(mathTeacherBean);
        LOGGER.info(scienceTeacherBean);
        LOGGER.info(englishTeacherBean);
        historyTeacherBean.teach();
        mathTeacherBean.teach();
        scienceTeacherBean.teach();
        englishTeacherBean.teach();
    }
}
