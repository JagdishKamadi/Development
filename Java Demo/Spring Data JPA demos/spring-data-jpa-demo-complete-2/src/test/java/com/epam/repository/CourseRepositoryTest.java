package com.epam.repository;

import com.epam.entity.Course;
import com.epam.entity.Guardian;
import com.epam.entity.Student;
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


    @Test
    void test_saveCourseWithStudentAndTeacherWithManToMany()
    {
        Teacher teacher = Teacher.builder()
                .firstName("Pavan")
                .lastName("Alapati")
                .build();

        Guardian guardian = Guardian.builder()
                .name("Tejas Gawande")
                .emailId("tejasgawande26@gmail.com")
                .phone("6546456456")
                .build();

        Student student1 = Student.builder()
                .firstName("Jagdish")
                .lastName("Kamadi")
                .emailId("jagdishKamadi@gmail.com")
                .guardian(guardian)
                .build();

        Student student2 = Student.builder()
                .firstName("Harshal")
                .lastName("Bhoyar")
                .emailId("harshalbhoyar@gmail.com")
                .guardian(guardian)
                .build();

        Course course = Course.builder()
                .title("Spring in Java")
                .credit(3)
                .teacher(teacher)
                .students(List.of(student1,student2))
                .build();

        courseRepository.save(course);
    }
}