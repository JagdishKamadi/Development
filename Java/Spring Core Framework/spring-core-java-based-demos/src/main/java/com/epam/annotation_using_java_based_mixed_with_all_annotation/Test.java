package com.epam.annotation_using_java_based_mixed_with_all_annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationClass.class, OtherConfigClass.class);
        College college = context.getBean("college", College.class);
        college.sayHelloToStudent();

        // below example shows using the @Import annotation
        Teacher scienceTeacherBean = context.getBean("scienceTeacher", ScienceTeacher.class);
        scienceTeacherBean.teach();

        context.close();
    }
}
