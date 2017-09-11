package com.toton.machines.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.toton.machines.annotation.FieldDefinition;

@Entity
public class Manufacturer extends ParentEntity {

	@Column(unique=true)
	@FieldDefinition(label="Manufacturer Name", order=10, htmltype="text", showoncreate=true, showonupdate=true, showonread=true)	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
