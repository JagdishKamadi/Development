package com.epam.controller;

import com.epam.entity.Employee;
import com.epam.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// we have set the base url also
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id)
    {
        return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getEmployees()
    {
        return new ResponseEntity<>(employeeService.getEmployees(),HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity<Employee> saveEmployee(@Valid  @RequestBody Employee employee)
    {
        return new ResponseEntity<> (employeeService.saveEmployee(employee),HttpStatus.CREATED);
    }

    @PutMapping("/{employee_id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("employee_id") Integer employeeId,@Valid @RequestBody Employee employee)
    {
        employee.setId(employeeId);
        return new ResponseEntity<>(employeeService.updateEmployee(employee),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Integer id)
    {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name){
        return new ResponseEntity<>(employeeService.getEmployeesByName(name),HttpStatus.OK);
    }

    @GetMapping("/findByNameAndDepartment")
    public ResponseEntity<List<Employee>> getEmployeesByNameAndDepartment(@RequestParam String name,@RequestParam String department)
    {
        return new ResponseEntity<>(employeeService.getEmployeesByNameAndDepartment(name,department),HttpStatus.OK);
    }

    @GetMapping("/getEmployeeNameByContaining")
    public ResponseEntity<List<Employee>> getEmployeeNameByContaining(@RequestParam String pattern)
    {
        return new ResponseEntity<>(employeeService.getEmployeeNameByContaining(pattern),HttpStatus.OK);
    }

    @GetMapping("/getNameContainingWithValidAge")
    public ResponseEntity<List<Employee>> getNameContainingWithValidAge(@RequestParam String pattern,@RequestParam Integer age)
    {
        return new ResponseEntity<>(employeeService.getNameContainingWithValidAge(pattern,age),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<HttpStatus> deleteEmployeeByName(@PathVariable String name)
    {
        employeeService.deleteEmployeeByName(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

