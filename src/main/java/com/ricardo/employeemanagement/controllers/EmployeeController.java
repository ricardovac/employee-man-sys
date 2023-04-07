package com.ricardo.employeemanagement.controllers;

import com.ricardo.employeemanagement.model.Employee;
import com.ricardo.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping(path = "/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }

    @GetMapping
    public List<Employee> findAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
        return employeeService.findEmployeeById(id);
    }

    @GetMapping("/updateEmployee/{id}")
    public String showFormForUpdate(@PathVariable int id, Model model) {
        Employee employee = employeeService.findEmployeeById(id);
        model.addAttribute("employee", employee);
        return "updateEmployee";
    }

    @GetMapping("/newEmployee")
    public String showNewEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "newEmployeeForm";
    }

    @RequestMapping(value = "/page/{pageNo}", method = RequestMethod.GET)
    public String findPaginated(@PathVariable int pageNo, Model model) {
        int pageSize = 10;
        int maxPagesToShow = 7;

        Page<Employee> page = employeeService.findPaginated(pageNo, pageSize);
        List<Employee> listEmployees = page.getContent();

        int startPage = Math.max(1, pageNo - maxPagesToShow / 2);
        int endPage = Math.min(page.getTotalPages(), pageNo + maxPagesToShow / 2);

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listEmployees", listEmployees);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "homePage";
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        return findPaginated(1, model);
    }
}
