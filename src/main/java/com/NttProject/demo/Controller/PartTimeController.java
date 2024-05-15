package com.NttProject.demo.Controller;

import com.NttProject.demo.Model.PartTime;
import com.NttProject.demo.Service.PartTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/part-time")
public class PartTimeController {

    private final PartTimeService partTimeService;

    public PartTimeController(PartTimeService partTimeService) {
        this.partTimeService = partTimeService;
    }

    /**
     * Creates a new part-time employee.
     *
     * @param employee the part-time employee to create.
     * @return the created part-time employee with an HTTP status of CREATED.
     */
    @PostMapping
    public ResponseEntity<PartTime> createPartTimeEmployee(@RequestBody PartTime employee) {
        PartTime createdEmployee = partTimeService.savePartTimeEmployee(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    /**
     * Retrieves all part-time employees.
     *
     * @return a list of all part-time employees with an HTTP status of OK.
     */
    @GetMapping
    public ResponseEntity<List<PartTime>> getAllPartTimeEmployees() {
        List<PartTime> employees = partTimeService.getAllPartTimeEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * Updates an existing part-time employee.
     *
     * @param id       the ID of the part-time employee to update.
     * @param employee the updated part-time employee.
     * @return the updated part-time employee with an HTTP status of OK.
     */
    @PutMapping("/{id}")
    public ResponseEntity<PartTime> updatePartTimeEmployee(@PathVariable Long id, @RequestBody PartTime employee) {
        PartTime updatedEmployee = partTimeService.updatePartTimeEmployee(id, employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

}
