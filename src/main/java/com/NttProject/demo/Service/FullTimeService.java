package com.NttProject.demo.Service;

import com.NttProject.demo.Model.FullTime;
import com.NttProject.demo.Repository.FullTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
