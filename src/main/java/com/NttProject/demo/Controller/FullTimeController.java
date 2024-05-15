package com.NttProject.demo.Controller;

import com.NttProject.demo.Model.FullTime;
import com.NttProject.demo.Service.FullTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/full-time")
public class FullTimeController {

    private final FullTimeService fullTimeService;

    public FullTimeController(FullTimeService fullTimeService) {
        this.fullTimeService = fullTimeService;
    }

    /**
     * Creates a new full-time employee.
     *
     * @param employee the full-time employee to create.
     * @return the created full-time employee with an HTTP status of CREATED.
     */
    @PostMapping
    public ResponseEntity<FullTime> createFullTimeEmployee(@RequestBody FullTime employee) {
        employee.setSalaryPerYear(employee.calculateSalary());
        FullTime createdEmployee = fullTimeService.saveFullTimeEmployee(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    /**
     * Retrieves all full-time employees.
     *
     * @return a list of all full-time employees with an HTTP status of OK.
     */
    @GetMapping
    public ResponseEntity<List<FullTime>> getAllFullTimeEmployees() {
        List<FullTime> employees = fullTimeService.getAllFullTimeEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * Updates an existing full-time employee.
     *
     * @param id       the ID of the full-time employee to update.
     * @param employee the updated full-time employee.
     * @return the updated full-time employee with an HTTP status of OK.
     */
    @PutMapping("/{id}")
    public ResponseEntity<FullTime> updateFullTimeEmployee(@PathVariable Long id, @RequestBody FullTime employee) {
        FullTime updatedEmployee = fullTimeService.updateFullTimeEmployee(id, employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }
}
