package com.toton.machines.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.toton.machines.annotation.FieldDefinition;

@Entity
public class AutomobileModelYear extends ParentEntity {

	@FieldDefinition(label="Year", order=10, htmltype="text")
	private String name;

    @ManyToOne  
	@FieldDefinition(label="Automobile Model", order=20)
	private AutomobileModel automobileModel;
	
	@FieldDefinition(label="Engine Placement", order=30, htmltype="select", options="front,mid,rear")
    private String enginePlacement;

	@FieldDefinition(label="Drive", order=40, htmltype="select", options="front,rear,awd,4wd")
    private String drive;
	
	@FieldDefinition(label="Passengers", order=50, htmltype="text", htmlsize=2)
    private Integer passengers;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AutomobileModel getAutomobileModel() {
		return automobileModel;
	}
	public void setAutomobileModel(AutomobileModel automobileModel) {
		this.automobileModel = automobileModel;
	}
	public String getDrive() {
		return drive;
	}
	public void setDrive(String drive) {
		this.drive = drive;
	}
	public String getEnginePlacement() {
		return enginePlacement;
	}
	public void setEnginePlacement(String enginePlacement) {
		this.enginePlacement = enginePlacement;
	}
	public Integer getPassengers() {
		return passengers;
	}
	public void setPassengers(Integer passengers) {
		this.passengers = passengers;
	}

	
	
}
