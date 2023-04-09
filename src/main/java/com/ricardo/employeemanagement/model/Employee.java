package com.ricardo.employeemanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @NotBlank
    @Column(name = "FIRST_NAME")
    private String firstName;
    @NotBlank
    @Column(name = "LAST_NAME")
    private String lastName;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Column(name = "ADDRESS")
    private String address;
    @NotBlank
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "DEPARTMENT")
    private String department;

    public Employee(String firstName, String lastName, String email, String address, String phone, String department, String photos) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.department = department;
    }

    public Employee() {

    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return firstName;
    }

    public void setFirst_name(String first_name) {
        this.firstName = first_name;
    }

    public String getLast_name() {
        return lastName;
    }

    public void setLast_name(String last_name) {
        this.lastName = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
