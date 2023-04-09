package com.ricardo.employeemanagement.service;

import com.ricardo.employeemanagement.exceptions.EmployeeNotFoundException;
import com.ricardo.employeemanagement.model.Employee;
import com.ricardo.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Employee employee = null;
        if (optionalEmployee.isPresent()) {
            employee = optionalEmployee.get();
        } else {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            employeeRepository.deleteById(id);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Page<Employee> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.employeeRepository.findAll(pageable);
    }
}
