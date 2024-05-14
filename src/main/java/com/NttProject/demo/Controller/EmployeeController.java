package com.NttProject.demo.Controller;


import com.NttProject.demo.Model.Contractor;
import com.NttProject.demo.Model.Employee;
import com.NttProject.demo.Model.FullTime;
import com.NttProject.demo.Model.PartTime;
import com.NttProject.demo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/part-time")
    public ResponseEntity<PartTime> createPartTimeEmployee(@RequestBody PartTime employee) {
        PartTime createdEmployee = employeeService.savePartTimeEmployee(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @PostMapping("full-time")
    public ResponseEntity<FullTime> createFullTimeEmployee(@RequestBody FullTime employee) {
        FullTime createdEmployee = employeeService.saveFullTimeEmployee(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @PostMapping("contractor")
    public ResponseEntity<Contractor> createContractor(@RequestBody Contractor employee) {
        Contractor createdEmployee = employeeService.saveContractor(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/full-time")
    public ResponseEntity<List<FullTime>> getAllFullTimeEmployees() {
        List<FullTime> employees = employeeService.getAllFullTimeEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/part-time")
    public ResponseEntity<List<PartTime>> getAllPartTimeEmployees() {
        List<PartTime> employees = employeeService.getAllPartTimeEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/contractor")
    public ResponseEntity<List<Contractor>> getAllContractors() {
        List<Contractor> employees = employeeService.getAllContractors();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}

