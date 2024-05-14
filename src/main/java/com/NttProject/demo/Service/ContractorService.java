package com.NttProject.demo.Service;

import com.NttProject.demo.Model.Contractor;
import com.NttProject.demo.Repository.ContractorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContractorService {

    private final ContractorRepository contractorRepository;

    @Autowired
    public ContractorService(ContractorRepository contractorRepository) {
        this.contractorRepository = contractorRepository;
    }

    /**
     * Saves a contractor.
     *
     * @param employee the contractor to save.
     * @return the saved contractor.
     */
    public Contractor saveContractor(Contractor employee) {
        return contractorRepository.save(employee);
    }

    /**
     * Retrieves all contractors.
     *
     * @return a list of all contractors.
     */
    public List<Contractor> getAllContractors() {
        return contractorRepository.findAll().stream()
                .filter(emplC -> emplC instanceof Contractor)
                .filter(emplC -> !emplC.isFlag())
                .map(emplC -> (Contractor) emplC)
                .collect(Collectors.toList());
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
        Contractor existingEmployee = contractorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contractor not found for this id : " + id));
        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setRole(updatedEmployee.getRole());
        existingEmployee.setHourlyRate(updatedEmployee.getHourlyRate());
        existingEmployee.setContractDuration((int) updatedEmployee.getContractDuration());
        return contractorRepository.save(existingEmployee);
    }
}
