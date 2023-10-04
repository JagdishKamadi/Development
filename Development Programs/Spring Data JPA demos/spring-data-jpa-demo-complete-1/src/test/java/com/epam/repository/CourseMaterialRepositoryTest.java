package com.epam.repository;

import com.epam.entity.Course;
import com.epam.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    void test_saveCourseMaterialWithCourse()
    {
        Course course = Course.builder()
                .title("Stream in java")
                .credit(2)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.edureka.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

}