package com.ricardo.employeemanagement.controllers;

import com.ricardo.employeemanagement.model.Employee;
import com.ricardo.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public Employee saveEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @GetMapping
    public Iterable<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeRepository.deleteById(id);
    }
}
