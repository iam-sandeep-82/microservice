package com.wipro.patient_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.patient_app.entity.PatientEntity;
import com.wipro.patient_app.entity.ServiceEntity;
import com.wipro.patient_app.proxy.OpenFeignProxy;
import com.wipro.patient_app.repos.PatientRepos;
import com.wipro.patient_app.service.PatientService;

import io.github.resilience4j.retry.annotation.Retry;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	PatientRepos patient_repos;
	@Autowired
	PatientService patient_service;
	@Autowired
	OpenFeignProxy feign_proxy;

	@GetMapping("/")
	public String __(ModelMap model) {
		return "index";
	}

	@GetMapping("/home")
	public String getHome(ModelMap model) {
		return "index";
	}

	@GetMapping("/reg-patient")
	@Retry(name = "patient_service", fallbackMethod = "getFallbackError")
	public String regPatient(ModelMap model) {
		List<ServiceEntity> services = feign_proxy.getAllServicesList();
		model.put("list_services_id", services);
		return "regPatient";
	}

	@GetMapping("/save-patient")
	public String savePatient(ModelMap model, @ModelAttribute("firstname") String firstname,
			@ModelAttribute("lastname") String lastname,
			@RequestParam("selected_service_id") List<Integer> selected_service_id) {

		PatientEntity new_patient = new PatientEntity(firstname, lastname, selected_service_id);
		PatientEntity save_patient = patient_service.savePatient(new_patient);
		if (save_patient != null) {
			model.addAttribute("patient_name", save_patient.getFirstname());
			return "regSuccess";
		}
		return "regFailed";
	}

	@GetMapping("/show-patient")
	public String showPatient(ModelMap model) {
		List<PatientEntity> list_patients = patient_service.findAll();
		model.put("list_patients", list_patients);
		return "showPatient";
	}

	//	SERVICE

	@GetMapping("/show-service")
	@Retry(name = "patient_service", fallbackMethod = "getFallbackError")
	public String showService(ModelMap model) {
		List<ServiceEntity> services = feign_proxy.getAllServicesList();
		model.put("list_services", services);
		return "showServices";
	}

	public String getFallbackError(ModelMap model, Exception e) {
		model.addAttribute("server_down_name", e.getClass());
		return "serviceError";

	}

	@GetMapping("/reg-service")
	public String regService(ModelMap model) {
		return "regService";
	}

	@PostMapping("/save-service")
	@Retry(name = "patient_service", fallbackMethod = "getFallbackError")
	public String saveService(ModelMap model, @RequestParam("name") String name, @RequestParam("price") int price,
			@RequestParam("ids") int ids) {
		System.out.println(name);
		System.out.println(price);
		System.out.println(ids);
		ServiceEntity serviceEntity = new ServiceEntity(ids, name, price);
		ServiceEntity save_service = feign_proxy.saveService(serviceEntity);

		if (save_service != null) {
			model.addAttribute("patient_name", save_service.getName());
			return "regSuccess";
		}
		return "regFailed";
	}


}
