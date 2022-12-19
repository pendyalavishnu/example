package com.employee.example;

import com.employee.example.model.Address;
import com.employee.example.model.Employee;
import com.employee.example.repository.AddressRepository;
import com.employee.example.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class ExampleApplication implements CommandLineRunner {

	@Autowired
	private final EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Address address1 = Address.builder().address("Hno: 1, lane no 1, Hyderabad").build();
		Address address2 = Address.builder().address("Hno: 2, lane no 2, Mumbai").build();

		Employee employee1 = Employee.builder().employeeName("Vishnu").employeeAddress(address1).build();
		Employee employee2 = Employee.builder().employeeName("Vardhan").employeeAddress(address2).build();

		employeeRepository.save(employee1);
		employeeRepository.save(employee2);

	}
}
