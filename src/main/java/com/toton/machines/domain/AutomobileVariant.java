package com.toton.machines.domain;

import javax.persistence.Entity;

//@Entity
public class AutomobileVariant extends ParentEntity {

	private AutomobileModel model;
	private Integer modelYear;	
	private String designation;
	
	private EngineVariant engine;
	
	private Float wheelbaseCm;
	private Float lengthCm;
	private Float widthCm;
	private Float heightCm;
	private Float curbWeightKg;
	
}
