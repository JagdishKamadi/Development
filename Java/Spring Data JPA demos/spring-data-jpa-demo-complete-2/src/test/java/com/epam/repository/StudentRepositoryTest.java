package com.epam.repository;

import com.epam.entity.Guardian;
import com.epam.entity.Student;
import com.epam.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

//    @Test
//    void test_studentSave()
//    {
//        Student student = Student.builder()
//                .firstName("Jagdish")
//                .lastName("Kamadi")
//                .emailId("jagadishkamadi@gmail.com")
//                .guardianName("Tejas Gawande")
//                .guardianEmailId("tejasgawande26@gmail.com")
//                .guardianPhone("5654645645")
//                .build();
//
//        studentRepository.save(student);
//    }

    @Test
    void test_studentWithGuardianSave() {
        Guardian guardian = Guardian.builder()
                .name("Kunal Karwatkar")
                .emailId("kunalkarwatkar@gmail.com")
                .phone("4354768898")
                .build();

        Student student = Student.builder()
                .firstName("Madhur")
                .lastName("Bhoyar")
                .emailId("madhyabhoyar@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    void test_findById() {
        Optional<Student> student = studentRepository.findById(1L);
        System.out.println(student.get());
    }

    @Test
    void test_findByFirstNameAndLastName() {
        List<Student> students = studentRepository.findByFirstNameAndLastName("Jagdish", "Kamadi");
        System.out.println(students.size());
        System.out.println(students);
    }

    @Test
    void test_findDistinctByLastname() {
        List<Student> students = studentRepository.findDistinctByLastName("Kamadi");
        System.out.println(students.size());
        System.out.println(students);
    }

    @Test
    void test_findByGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("Tejas Gawande");
        System.out.println(students.size());
        System.out.println(students);
    }

    @Test
    void test_findByGuardianPhoneOrEmailId() {
        List<Student> students = studentRepository.findByGuardianPhoneOrEmailId("4534544545", "harshgawande@gmail.com");
        System.out.println(students.size());
        System.out.println(students);
    }

    @Test
    void test_getListByFirstName() {
        System.out.println(studentRepository.getPhoneListByFirstName("Jagdish"));
    }

    @Test
    void test_getEmailListByFirstName() {
        System.out.println(studentRepository.getEmailListByFirstName("Jagdish"));
    }

    @Test
    void test_getEmailListByFirstNameUsingNativeQuery() {
        System.out.println(studentRepository.getEmailListByFirstNameUsingNativeQuery("Jagdish"));
    }

    @Test
    void test_findTopN() {
        System.out.println(studentRepository.findTopN(2));
    }


    @Test
    void test_getEmailListByFirstNameUsingQueryNamedParam() {
        System.out.println(studentRepository.getEmailListByFirstNameUsingQueryNamedParam("Jagdish"));
    }

    @Test
    void test_getNStudent() {
        System.out.println(studentRepository.getNStudent("Jagdish", 1));
    }

    @Test
    void test_updateFirstNameUsingEmailId() {
        studentRepository.updateFirstNameUsingEmailId("jagadishkamadi@gmail.com", "Pravin");
        System.out.println(studentRepository.findAll());
    }

    @Test
    void test_updateFirstNameUsingEmailIdUsingJPQL()
    {
        studentRepository.updateFirstNameUsingEmailIdUsingJPQL("jagadishkamadi@gmail.com", "Jagdish");
        System.out.println(studentRepository.findAll());
    }
}