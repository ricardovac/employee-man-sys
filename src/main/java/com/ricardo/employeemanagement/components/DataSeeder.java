package com.ricardo.employeemanagement.components;

import com.ricardo.employeemanagement.model.Employee;
import com.ricardo.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataSeeder implements CommandLineRunner {
    @Autowired
    protected EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Employee> users = new ArrayList<>();

        String[] firstNames = {
                "John", "Jane", "Bob", "Alice", "Mike", "Maggie", "Sam", "Emily", "David", "Olivia",
                "Ben", "Sophie", "Chris", "Lena", "Isaac", "Nina", "Ethan", "Sara", "Tom", "Julia", "Alex", "Lily",
                "Max", "Ava", "Jake", "Lucy", "Nick", "Amy", "Leo", "Grace", "Oscar", "Hannah", "Henry", "Rachel",
                "Luke", "Ellie", "Mark", "Leah", "Eric", "Zoe", "Paul", "Eva", "Adam", "Avery", "Nate", "Lila"
        };

        String[] lastNames = {
                "Doe", "Smith", "Johnson", "Brown", "Davis", "Wilson", "Garcia", "Jones", "Martinez",
                "Anderson", "Thomas", "Jackson", "Taylor", "White", "Harris", "Moore", "Allen", "Martin",
                "King", "Wright", "Scott", "Walker", "Hall", "Young", "Lee", "Green", "Baker", "Adams", "Nelson",
                "Carter", "Mitchell", "Perez", "Roberts", "Turner", "Phillips", "Campbell", "Parker", "Evans",
                "Edwards", "Collins", "Stewart", "Sanchez", "Morris", "Rogers", "Reed", "Cook"
        };

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            String firstName = firstNames[random.nextInt(firstNames.length)];
            String lastName = lastNames[random.nextInt(lastNames.length)];
            String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@example.com";

            Employee employee = new Employee();
            employee.setFirst_name(firstName);
            employee.setLast_name(lastName);
            employee.setEmail(email);

            users.add(employee);
        }

        employeeRepository.saveAll(users);
    }
}
