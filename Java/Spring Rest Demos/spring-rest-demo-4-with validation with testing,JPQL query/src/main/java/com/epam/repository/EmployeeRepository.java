package com.epam.repository;

import com.epam.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    // SELECT * FROM employee WHERE name=?
    List<Employee> findByName(String name);

    // SELECT * FROM employee WHERE name=? AND department=?
    List<Employee> findByNameAndDepartment(String name,String department);

    // SELECT * FROM employee WHERE name like %pattern%
    List<Employee> findByNameContaining(String pattern);

    @Query(value = "FROM Employee WHERE name LIKE %:pattern% AND age>= :age")
    List<Employee> findByNameContainingWithValidAge(String pattern,Integer age);

    // whenever we want to perform DML operation we have to use the @Transaction annotation
    @Transactional
    Integer deleteByName(String name);
}
