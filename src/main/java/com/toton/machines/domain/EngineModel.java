package com.toton.machines.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class EngineModel extends ParentEntity {

	private String name;
	
	@OneToOne
	private EngineConfiguration engineConfiguration;
	
	@OneToOne
	private FuelType fuelType;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public EngineConfiguration getEngineConfiguration() {
		return engineConfiguration;
	}
	public void setEngineConfiguration(EngineConfiguration engineConfiguration) {
		this.engineConfiguration = engineConfiguration;
	}
	
	public FuelType getFuelType() {
		return fuelType;
	}
	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}
	
}
