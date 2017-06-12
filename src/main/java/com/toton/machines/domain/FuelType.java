package com.toton.machines.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class FuelType extends ParentEntity {

	@Column(length = 128, nullable = false, unique=true)
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
}
