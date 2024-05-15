package com.NttProject.demo.Repository;


import com.NttProject.demo.Model.FullTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FullTimeRepository extends JpaRepository<FullTime, Long> {

}
