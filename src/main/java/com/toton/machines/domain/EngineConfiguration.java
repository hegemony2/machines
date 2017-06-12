package com.toton.machines.domain;

import javax.persistence.Entity;

@Entity
public class EngineConfiguration extends ParentEntity {

	private String name;
	private int cylinders;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCylinders() {
		return cylinders;
	}
	public void setCylinders(int cylinders) {
		this.cylinders = cylinders;
	}
		
}
