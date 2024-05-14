package com.NttProject.demo.Repository;

import com.NttProject.demo.Model.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractorRepository extends JpaRepository<Contractor,Long> {
}
