package com.NttProject.demo.Service;

import com.NttProject.demo.Model.FullTime;
import com.NttProject.demo.Repository.FullTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FullTimeService {

    private final FullTimeRepository fullTimeRepository;

    @Autowired
    public FullTimeService(FullTimeRepository fullTimeRepository) {
        this.fullTimeRepository = fullTimeRepository;
    }

    /**
     * Saves a full-time employee.
     *
     * @param employee the full-time employee to save.
     * @return the saved full-time employee.
     */
    public FullTime saveFullTimeEmployee(FullTime employee) {
        return fullTimeRepository.save(employee);
    }

    /**
     * Retrieves all full-time employees.
     *
     * @return a list of all full-time employees.
     */
    public List<FullTime> getAllFullTimeEmployees() {
        return fullTimeRepository.findAll().stream()
                .filter(emplF -> emplF instanceof FullTime)
                .filter(emplf -> !emplf.isFlag())
                .map(emplF -> (FullTime) emplF)
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
        FullTime existingEmployee = fullTimeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "FullTime Employee not found for this id : " + id));
        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setRole(updatedEmployee.getRole());
        existingEmployee.setSalaryPerYear(updatedEmployee.getSalaryPerYear());
        return fullTimeRepository.save(existingEmployee);
    }

}
