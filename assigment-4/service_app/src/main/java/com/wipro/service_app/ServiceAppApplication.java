package com.wipro.service_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceAppApplication.class, args);
		System.out.println();
		System.out.println("SERVICE MICROSERVICE RUNNING :)");
	}

}
