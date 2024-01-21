package com.epam.repository;

import com.epam.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    List<Student> findDistinctByLastName(String lastName);

    /* below method is very important */
    List<Student> findByGuardianName(String name);

    List<Student> findByGuardianPhoneOrEmailId(String phone, String emailId);

    // below is the JPQL query
    @Query("select s.emailId from Student s where s.firstName =?1")
    List<String> getEmailListByFirstName(String firstName);

    @Query("select s.guardian.phone from Student s where s.firstName =?1")
    List<String> getPhoneListByFirstName(String firstName);

    // below is the Native Query
    @Query(
            value = "SELECT s.email_id FROM student s WHERE s.first_name =?1",
            nativeQuery = true)
    List<String> getEmailListByFirstNameUsingNativeQuery(String firstName);

    @Query(
            value = "SELECT * FROM Student  limit :limit",
            nativeQuery = true)
    public List<Student> findTopN(@Param("limit") int limit);


    // below is the Query named param
    @Query(
            value = "SELECT s.email_id FROM student s WHERE s.first_name =:firstName",
            nativeQuery = true)
    List<String> getEmailListByFirstNameUsingQueryNamedParam(@Param("firstName") String firstName);


    // limiting the query
    @Query(
            value = "SELECT * FROM student WHERE first_name=?1 LIMIT ?2",
            nativeQuery = true
    )
    List<Student> getNStudent(String firstname, Integer limit);

    // update query using native query
    @Modifying
    @Transactional
    @Query(
            value = "UPDATE student SET first_name=:firstName WHERE email_id =:emailId",
            nativeQuery = true)
    Integer updateFirstNameUsingEmailId(@Param("emailId") String email, @Param("firstName") String firstName);

    // update query using JPQL
    @Modifying
    @Transactional
    @Query("update Student set firstName=:firstName where emailId =:emailId")
    Integer updateFirstNameUsingEmailIdUsingJPQL(@Param("emailId") String email, @Param("firstName") String firstName);


}
