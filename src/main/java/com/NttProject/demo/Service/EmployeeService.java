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

/**
 * Service class for handling Employee-related operations.
 */
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    /**
     * Constructs an EmployeeService with the specified EmployeeRepository.
     *
     * @param employeeRepository the EmployeeRepository to be used.
     */
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Retrieves an employee by their ID.
     *
     * @param id the ID of the employee to retrieve.
     * @return the employee with the specified ID.
     * @throws ResponseStatusException if the employee is not found.
     */
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found for this id : " + id));
    }

    /**
     * Retrieves all employees.
     *
     * @return a list of all employees.
     */
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /**
     * Deletes an employee by their ID.
     *
     * @param id the ID of the employee to delete.
     * @throws ResponseStatusException if the employee is not found.
     */
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found for this id : " + id));
        employee.setFlag(true);
        employeeRepository.save(employee);
    }

    /**
     * Retrieves all contractors.
     *
     * @return a list of all contractors.
     */
    public List<Contractor> getAllContractors() {
        return employeeRepository.findAll().stream()
                .filter(emplC -> emplC instanceof Contractor)
                .filter(emplC -> !emplC.isFlag())
                .map(emplC -> (Contractor) emplC)
                .collect(Collectors.toList());
    }

    /**
     * Updates an existing full-time employee.
     *
     * @param id the ID of the full-time employee to update.
     * @param updatedEmployee the updated full-time employee.
     * @return the updated full-time employee.
     * @throws ResponseStatusException if the full-time employee is not found.
     */
    public FullTime updateFullTimeEmployee(Long id, FullTime updatedEmployee) {
        FullTime existingEmployee = (FullTime) employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "FullTime Employee not found for this id : " + id));
        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setRole(updatedEmployee.getRole());
        existingEmployee.setSalaryPerYear(updatedEmployee.getSalaryPerYear());
        return employeeRepository.save(existingEmployee);
    }

    /**
     * Updates an existing part-time employee.
     *
     * @param id the ID of the part-time employee to update.
     * @param updatedEmployee the updated part-time employee.
     * @return the updated part-time employee.
     * @throws ResponseStatusException if the part-time employee is not found.
     */
    public PartTime updatePartTimeEmployee(Long id, PartTime updatedEmployee) {
        PartTime existingEmployee = (PartTime) employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "PartTime Employee not found for this id : " + id));
        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setRole(updatedEmployee.getRole());
        existingEmployee.setHourlyRate(updatedEmployee.getHourlyRate());
        return employeeRepository.save(existingEmployee);
    }

    /**
     * Updates an existing contractor.
     *
     * @param id the ID of the contractor to update.
     * @param updatedEmployee the updated contractor.
     * @return the updated contractor.
     * @throws ResponseStatusException if the contractor is not found.
     */
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
