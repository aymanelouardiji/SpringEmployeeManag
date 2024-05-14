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
        employee.setFlag(true);
        employeeRepository.save(employee);
    }

    public List<FullTime> getAllFullTimeEmployees() {
        return employeeRepository.findAll().stream()
                .filter(emplF -> emplF instanceof FullTime)
                .filter(emplf -> !emplf.isFlag())
                .map(emplF -> (FullTime) emplF)
                .collect(Collectors.toList());
    }

    public List<PartTime> getAllPartTimeEmployees() {
        return employeeRepository.findAll().stream()
                .filter(emplP -> emplP instanceof PartTime)
                .filter(emplP -> !emplP.isFlag())
                .map(emplP -> (PartTime) emplP)
                .collect(Collectors.toList());
    }

    public List<Contractor> getAllContractors() {
        return employeeRepository.findAll().stream()
                .filter(emplC -> emplC instanceof Contractor)
                .filter(emplC -> !emplC.isFlag())
                .map(emplC -> (Contractor) emplC)
                .collect(Collectors.toList());
    }
    public FullTime updateFullTimeEmployee(Long id, FullTime updatedEmployee) {
        FullTime existingEmployee = (FullTime) employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "FullTime Employee not found for this id : " + id));
        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setRole(updatedEmployee.getRole());
        existingEmployee.setSalaryPerYear(updatedEmployee.getSalaryPerYear());
        return employeeRepository.save(existingEmployee);
    }

    public PartTime updatePartTimeEmployee(Long id, PartTime updatedEmployee) {
        PartTime existingEmployee = (PartTime) employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "PartTime Employee not found for this id : " + id));
        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setRole(updatedEmployee.getRole());
        existingEmployee.setHourlyRate(updatedEmployee.getHourlyRate());
        return employeeRepository.save(existingEmployee);
    }

    public Contractor updateContractor(Long id, Contractor updatedEmployee) {
        Contractor existingEmployee = (Contractor) employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contractor not found for this id : " + id));
        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setRole(updatedEmployee.getRole());
        existingEmployee.setHourlyRate(updatedEmployee.getHourlyRate());
        existingEmployee.setContractDuration((int) updatedEmployee.getContractDuration());
        return employeeRepository.save(existingEmployee);
    }
}
