package com.epam.annotation_using_java_based_mixed;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


/**
 * Here are the all example of dependencies injection
 * 1) using property
 * 2) using setter
 * 3) using constructor
 * 4) using @Qualifier annotation
 */
@Component
public class College {
    private static final Logger logger = LogManager.getLogger(College.class);

    @Value("BIT")
    private String collegeName;

    @Value("${java.home}")
    private String javaHome;

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
    @Lazy(value = false)
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
        logger.info("Java home path " + javaHome);
        logger.info("Hi Student, Welcome to the " + collegeName);
        logger.info(historyTeacherBean);
        logger.info(mathTeacherBean);
        logger.info(scienceTeacherBean);
        logger.info(englishTeacherBean);
        historyTeacherBean.teach();
        mathTeacherBean.teach();
        scienceTeacherBean.teach();
        englishTeacherBean.teach();
    }
}
