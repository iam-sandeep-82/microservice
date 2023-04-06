package com.wipro.patient_app.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PatientEntity{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	//	@Size(min = 8, message = "Enter atleast 8 characters")
	private String firstname;
	private String lastname;
	//	private int services;
	List<Integer> list_service = new ArrayList<>();

	public PatientEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PatientEntity(String firstname, String lastname, List<Integer> list_service) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.list_service = list_service;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	//	public int getService() {
	//		return services;
	//	}
	//
	//	public void setService(int service) {
	//		this.services = service;
	//	}

	@Override
	public String toString() {
		return "PatientModel [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", services="
				+ "]";
	}

	public List<Integer> getList_service() {
		return list_service;
	}

	public void setList_service(List<Integer> list_service) {
		this.list_service = list_service;
	}

}
