package com.wipro.patient_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wipro.patient_app.service.PatientService;

@Configuration
@SpringBootApplication
@EnableFeignClients
public class PatientAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(PatientAppApplication.class, args);
		System.out.println();
		System.out.println("PATIENT MICROSERVICE RUNNING :)");
	}

	@Bean
	public PatientService patientService() {
		return new PatientService();
	}

}
