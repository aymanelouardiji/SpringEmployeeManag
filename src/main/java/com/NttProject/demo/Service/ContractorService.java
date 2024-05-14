package com.NttProject.demo.Service;

import com.NttProject.demo.Model.Contractor;
import com.NttProject.demo.Repository.ContractorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
