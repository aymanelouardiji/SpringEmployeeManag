package com.NttProject.demo.Repository;

import com.NttProject.demo.Model.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractorRepository extends JpaRepository<Contractor,Long> {
    public List<Contractor> findAllByFlagFalse();
}
