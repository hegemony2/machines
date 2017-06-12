package com.toton.machines.domain;

import javax.persistence.Entity;

//@Entity
public class Valvetrain extends ParentEntity {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
}
