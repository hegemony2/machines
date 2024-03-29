package com.toton.machines.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.toton.machines.annotation.FieldDefinition;

@Entity
public class AutomobileModel extends ParentEntity {

	@FieldDefinition(label="Model Name", order=20, htmltype="text")
	private String name;
	
    @ManyToOne  
	@FieldDefinition(label="Manufacturer", order=10)
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
