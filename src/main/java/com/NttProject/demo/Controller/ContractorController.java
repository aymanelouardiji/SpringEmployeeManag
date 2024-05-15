package com.NttProject.demo.Controller;

import com.NttProject.demo.Model.Contractor;
import com.NttProject.demo.Service.ContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contractor")
public class ContractorController {

    private final ContractorService contractorService;

    public ContractorController(ContractorService contractorService) {
        this.contractorService = contractorService;
    }

    /**
     * Creates a new contractor.
     *
     * @param employee the contractor to create.
     * @return the created contractor with an HTTP status of CREATED.
     */
    @PostMapping
    public ResponseEntity<Contractor> createContractor(@RequestBody Contractor employee) {
        employee.setSalary(employee.calculateSalary());
        Contractor createdEmployee = contractorService.saveContractor(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    /**
     * Retrieves all contractors.
     *
     * @return a list of all contractors with an HTTP status of OK.
     */
    @GetMapping
    public ResponseEntity<List<Contractor>> getAllContractors() {
        List<Contractor> employees = contractorService.getAllContractors();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * Updates an existing contractor.
     *
     * @param id       the ID of the contractor to update.
     * @param employee the updated contractor.
     * @return the updated contractor with an HTTP status of OK.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Contractor> updateContractor(@PathVariable Long id, @RequestBody Contractor employee) {
        Contractor updatedEmployee = contractorService.updateContractor(id, employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }
}
