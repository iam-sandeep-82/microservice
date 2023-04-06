package com.wipro.patient_app.entity;

public class ServiceEntity {
	private int ids;
	private String name;
	private int price;

	public ServiceEntity() {
	}

	public ServiceEntity(int ids, String name, int price) {
		super();
		this.ids = ids;
		this.name = name;
		this.price = price;
	}

	public int getIds() {
		return ids;
	}

	public void setIds(int ids) {
		this.ids = ids;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
