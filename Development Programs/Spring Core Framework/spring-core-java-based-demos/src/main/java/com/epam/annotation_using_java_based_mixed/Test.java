package com.epam.annotation_using_java_based_mixed;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationClass.class);
        College college = context.getBean("college", College.class);
        college.sayHelloToStudent();

        Teacher teacher1 = context.getBean("historyTeacher", HistoryTeacher.class);
        teacher1.teach();
        context.close();
    }
}
