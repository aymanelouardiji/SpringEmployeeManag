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

/**
 * Rest Controller for handling Employee-related operations.
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Retrieves all employees.
     *
     * @return a list of all employees with an HTTP status of OK.
     */
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * Creates a new part-time employee.
     *
     * @param employee the part-time employee to create.
     * @return the created part-time employee with an HTTP status of CREATED.
     */
    @PostMapping("/part-time")
    public ResponseEntity<PartTime> createPartTimeEmployee(@RequestBody PartTime employee) {
        PartTime createdEmployee = employeeService.savePartTimeEmployee(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    /**
     * Creates a new full-time employee.
     *
     * @param employee the full-time employee to create.
     * @return the created full-time employee with an HTTP status of CREATED.
     */
    @PostMapping("full-time")
    public ResponseEntity<FullTime> createFullTimeEmployee(@RequestBody FullTime employee) {
        FullTime createdEmployee = employeeService.saveFullTimeEmployee(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    /**
     * Creates a new contractor.
     *
     * @param employee the contractor to create.
     * @return the created contractor with an HTTP status of CREATED.
     */
    @PostMapping("contractor")
    public ResponseEntity<Contractor> createContractor(@RequestBody Contractor employee) {
        Contractor createdEmployee = employeeService.saveContractor(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    /**
     * Retrieves an employee by their ID.
     *
     * @param id the ID of the employee to retrieve.
     * @return the employee with the specified ID and an HTTP status of OK.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    /**
     * Deletes an employee by their ID.
     *
     * @param id the ID of the employee to delete.
     * @return an HTTP status of NO_CONTENT.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Retrieves all full-time employees.
     *
     * @return a list of all full-time employees with an HTTP status of OK.
     */
    @GetMapping("/full-time")
    public ResponseEntity<List<FullTime>> getAllFullTimeEmployees() {
        List<FullTime> employees = employeeService.getAllFullTimeEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * Retrieves all part-time employees.
     *
     * @return a list of all part-time employees with an HTTP status of OK.
     */
    @GetMapping("/part-time")
    public ResponseEntity<List<PartTime>> getAllPartTimeEmployees() {
        List<PartTime> employees = employeeService.getAllPartTimeEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * Retrieves all contractors.
     *
     * @return a list of all contractors with an HTTP status of OK.
     */
    @GetMapping("/contractor")
    public ResponseEntity<List<Contractor>> getAllContractors() {
        List<Contractor> employees = employeeService.getAllContractors();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * Updates an existing part-time employee.
     *
     * @param id the ID of the part-time employee to update.
     * @param employee the updated part-time employee.
     * @return the updated part-time employee with an HTTP status of OK.
     */
    @PutMapping("/part-time/{id}")
    public ResponseEntity<PartTime> updatePartTimeEmployee(@PathVariable Long id, @RequestBody PartTime employee) {
        PartTime updatedEmployee = employeeService.updatePartTimeEmployee(id, employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    /**
     * Updates an existing full-time employee.
     *
     * @param id the ID of the full-time employee to update.
     * @param employee the updated full-time employee.
     * @return the updated full-time employee with an HTTP status of OK.
     */
    @PutMapping("/full-time/{id}")
    public ResponseEntity<FullTime> updateFullTimeEmployee(@PathVariable Long id, @RequestBody FullTime employee) {
        FullTime updatedEmployee = employeeService.updateFullTimeEmployee(id, employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    /**
     * Updates an existing contractor.
     *
     * @param id the ID of the contractor to update.
     * @param employee the updated contractor.
     * @return the updated contractor with an HTTP status of OK.
     */
    @PutMapping("/contractor/{id}")
    public ResponseEntity<Contractor> updateContractor(@PathVariable Long id, @RequestBody Contractor employee) {
        Contractor updatedEmployee = employeeService.updateContractor(id, employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }
}
