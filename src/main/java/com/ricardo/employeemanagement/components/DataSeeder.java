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

        String[] streetNames = {"Main St.", "Oak St.", "Elm St.", "Maple Ave.", "Cedar Ln."};
        String[] cities = {"New York", "Los Angeles", "Chicago", "Houston", "Phoenix", "Philadelphia", "San Antonio", "San Diego", "Dallas", "San Jose"};
        String[] states = {"NY", "CA", "IL", "TX", "AZ", "PA", "TX", "CA", "TX", "CA"};
        String[] phones = {"123", "456", "789", "555", "111", "222", "333", "444", "666", "777", "888", "999"};
        String[] departaments = {"Sales", "Engineering", "Human Resources", "Marketing"};

        String[] address = new String[41];
        for (int i = 0; i < address.length; i++) {
            int streetIndex = (int) (Math.random() * streetNames.length);
            int cityIndex = (int) (Math.random() * cities.length);
            int stateIndex = (int) (Math.random() * states.length);
            int zipCode = (int) (Math.random() * 90000) + 10000; // Generate a random 5-digit number between 10000 and 99999
            address[i] = streetNames[streetIndex] + ", " + cities[cityIndex] + ", " + states[stateIndex] + " " + zipCode;
        }

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            String firstName = firstNames[random.nextInt(firstNames.length)];
            String lastName = lastNames[random.nextInt(lastNames.length)];
            String addressFill = address[random.nextInt(address.length)];
            String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@example.com";
            String phone = phones[random.nextInt(phones.length)];
            String departament = departaments[random.nextInt(departaments.length)];

            Employee employee = new Employee();
            employee.setFirst_name(firstName);
            employee.setLast_name(lastName);
            employee.setEmail(email);
            employee.setAddress(addressFill);
            employee.setPhone(phone);
            employee.setDepartment(departament);

            users.add(employee);
        }

        employeeRepository.saveAll(users);
    }
}
