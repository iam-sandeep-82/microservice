package com.wipro.patient_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wipro.patient_app.entity.PatientEntity;

public class PatientService {
	@Autowired
	com.wipro.patient_app.repos.PatientRepos patient_repos;

	public PatientEntity savePatient(PatientEntity patient) {
		return patient_repos.save(patient);
	}

	public List<PatientEntity> findAll() {
		return patient_repos.findAll();
	}

}
