package com.wipro.patient_app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.patient_app.entity.PatientEntity;

@Repository
public interface PatientRepos extends JpaRepository<PatientEntity, Integer> {
}

