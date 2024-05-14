package com.NttProject.demo.Repository;

import com.NttProject.demo.Model.PartTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartTimeRepository extends JpaRepository<PartTime,Long> {
}
