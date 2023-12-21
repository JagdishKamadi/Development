package com.epam.repository;

import com.epam.entity.Course;
import com.epam.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void test_findAll()
    {
        System.out.println(courseRepository.findAll());
    }

    @Test
    void test_saveCourseWithTeacher()
    {
        Teacher teacher = Teacher.builder()
                .firstName("Rajesh")
                .lastName("Ingale")
                .build();

        Course c1 = Course.builder()
                .title("Hibernate tutorial")
                .credit(2)
                .teacher(teacher)
                .build();

        Course c2 = Course.builder()
                .title("Jpa tutorial")
                .credit(3)
                .teacher(teacher)
                .build();

        courseRepository.saveAll(List.of(c1,c2));

    }
}