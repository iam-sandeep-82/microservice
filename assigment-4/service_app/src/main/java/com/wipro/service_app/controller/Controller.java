package com.wipro.service_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.service_app.entity.ServiceEntity;
import com.wipro.service_app.repos.ServicesRepos;

@RestController
public class Controller {

	@Autowired
	ServicesRepos services_repos;

	@GetMapping("/service")
	public ServiceEntity getallServices() {
		return new ServiceEntity("x-ray", 9000);
	}

	@GetMapping("/get-all-services")
	public List<ServiceEntity> getAllServices() {
		return services_repos.findAll();
	}

	@PostMapping("/save-service")
	public ServiceEntity saveService(ServiceEntity serviceEntity) {
		System.out.println(serviceEntity.getName());
		ServiceEntity se = services_repos.save(serviceEntity);
		return se;
	}

}
