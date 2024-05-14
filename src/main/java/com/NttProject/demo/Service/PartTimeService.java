package com.NttProject.demo.Service;

import com.NttProject.demo.Model.PartTime;
import com.NttProject.demo.Repository.PartTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartTimeService {

    private final PartTimeRepository partTimeRepository;

    @Autowired
    public PartTimeService(PartTimeRepository partTimeRepository) {
        this.partTimeRepository = partTimeRepository;
    }

    /**
     * Saves a part-time employee.
     *
     * @param employee the part-time employee to save.
     * @return the saved part-time employee.
     */
    public PartTime savePartTimeEmployee(PartTime employee) {
        return partTimeRepository.save(employee);
    }

    /**
     * Retrieves all part-time employees.
     *
     * @return a list of all part-time employees.
     */
    public List<PartTime> getAllPartTimeEmployees() {
        return partTimeRepository.findAll().stream()
                .filter(emplP -> emplP instanceof PartTime)
                .filter(emplP -> !emplP.isFlag())
                .map(emplP -> (PartTime) emplP)
                .collect(Collectors.toList());
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
        PartTime existingEmployee = partTimeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "PartTime Employee not found for this id : " + id));
        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setRole(updatedEmployee.getRole());
        existingEmployee.setHourlyRate(updatedEmployee.getHourlyRate());
        return partTimeRepository.save(existingEmployee);
    }
}
