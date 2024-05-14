package com.NttProject.demo.Service;

import com.NttProject.demo.Model.PartTime;
import com.NttProject.demo.Repository.PartTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
