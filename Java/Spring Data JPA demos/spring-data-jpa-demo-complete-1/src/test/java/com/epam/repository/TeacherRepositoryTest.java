package com.epam.repository;

import com.epam.entity.Course;
import com.epam.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    void test_saveTeacher()
    {
        Course c1 = Course.builder()
                .title("Java in 60 hours")
                .credit(4)
                .build();

        Course c2 = Course.builder()
                .title("Drilling in c")
                .credit(3)
                .build();

        List<Course> courseList = Arrays.asList(c1,c2);

        Teacher teacher = Teacher.builder()
                .firstName("Pavan")
                .lastName("Alapati")
//                .courses(courseList)
                .build();

        teacherRepository.save(teacher);
    }
}