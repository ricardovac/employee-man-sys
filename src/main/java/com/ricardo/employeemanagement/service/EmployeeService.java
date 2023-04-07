package com.ricardo.employeemanagement.service;

import com.ricardo.employeemanagement.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    public void saveEmployee(Employee employee);

    public List<Employee> findAllEmployees();

    public Employee findEmployeeById(int id);

    public void deleteEmployee(int id);

    public Page<Employee> findPaginated(int pageNo, int pageSize);
}
