package com.toton.machines.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class AutomobileModel extends ParentEntity {

	private String name;
	
    @ManyToOne  
	private Manufacturer manufacturer;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Manufacturer getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	
}
