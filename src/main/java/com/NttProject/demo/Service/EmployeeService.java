package com.NttProject.demo.Service;

import com.NttProject.demo.Model.Contractor;
import com.NttProject.demo.Model.Employee;
import com.NttProject.demo.Model.FullTime;
import com.NttProject.demo.Model.PartTime;
import com.NttProject.demo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public FullTime saveFullTimeEmployee(FullTime employee) {
        return employeeRepository.save(employee);
    }

    public PartTime savePartTimeEmployee(PartTime employee) {
        return employeeRepository.save(employee);
    }

    public Contractor saveContractor(Contractor employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found for this id : " + id));
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found for this id : " + id));
        employeeRepository.delete(employee);
    }

    public List<FullTime> getAllFullTimeEmployees() {
        return employeeRepository.findAll().stream()
                .filter(emplF -> emplF instanceof FullTime)
                .map(emplF -> (FullTime) emplF)
                .collect(Collectors.toList());
    }

    public List<PartTime> getAllPartTimeEmployees() {
        return employeeRepository.findAll().stream()
                .filter(emplP -> emplP instanceof PartTime)
                .map(emplP -> (PartTime) emplP)
                .collect(Collectors.toList());
    }

    public List<Contractor> getAllContractors() {
        return employeeRepository.findAll().stream()
                .filter(emplC -> emplC instanceof Contractor)
                .map(emplC -> (Contractor) emplC)
                .collect(Collectors.toList());
    }
}
