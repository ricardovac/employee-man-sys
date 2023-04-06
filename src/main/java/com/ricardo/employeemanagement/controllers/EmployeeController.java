package com.ricardo.employeemanagement.controllers;

import com.ricardo.employeemanagement.exceptions.EmployeeNotFoundException;
import com.ricardo.employeemanagement.model.Employee;
import com.ricardo.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public Employee saveEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @GetMapping
    public Iterable<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping(path = "/page/{pageNumber}/{employeesAmount}")
    public Iterable<Employee> getProductsByPages(
            @PathVariable int pageNumber,
            @PathVariable int employeesAmount
    ) {
        if (employeesAmount >= 5) employeesAmount = 5;
        PageRequest page = PageRequest.of(pageNumber, employeesAmount);
        return employeeRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
        return employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeRepository.deleteById(id);
    }
}
