package com.employee.example.controller;

import com.employee.example.model.Employee;
import com.employee.example.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MainController {

    @Autowired
    private final EmployeeRepository employeeRepository;


    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(employeeRepository.getReferenceById(id));
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam("name") String name){
        if(name.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(employeeRepository.findAll());
        }
        return ResponseEntity.status(HttpStatus.OK).body(employeeRepository.findByEmployeeName(name));
    }



    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/employee")
    public void deleteEmployee(long id){
        employeeRepository.deleteById(id);
    }

    @PutMapping("/employee")
    public void updateEmployee(@RequestBody Employee employee){
        employeeRepository.save(employee);
    }
}

