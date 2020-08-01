package com.company.mz.mortgage.repository;

import com.company.mz.mortgage.entity.MortgageApplication;
import com.company.mz.mortgage.entity.Resolution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MortgageApplicationRepository extends JpaRepository<MortgageApplication, Long> {
//    List<MortgageApplication> getAllByStatusEquals(Resolution resolution);
}
