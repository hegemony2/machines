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
	
	@FieldDefinition(label="Wheelbase (in)", order=50, htmltype="text", htmlsize=5)
	private Float wheelbaseIn;
	
	@FieldDefinition(label="Length (in)", order=60, htmltype="text", htmlsize=5)	
	private Float lengthIn;
	
	@FieldDefinition(label="Width (in)", order=70, htmltype="text", htmlsize=5)	
	private Float widthIn;
	
	@FieldDefinition(label="Height (in)", order=80, htmltype="text", htmlsize=5)	
	private Float heigthIn;
	
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
	public Float getWheelbaseIn() {
		return wheelbaseIn;
	}
	public void setWheelbaseIn(Float wheelbaseIn) {
		this.wheelbaseIn = wheelbaseIn;
	}
	public Float getLengthIn() {
		return lengthIn;
	}
	public void setLengthIn(Float lengthIn) {
		this.lengthIn = lengthIn;
	}
	public Float getWidthIn() {
		return widthIn;
	}
	public void setWidthIn(Float widthIn) {
		this.widthIn = widthIn;
	}
	public Float getHeigthIn() {
		return heigthIn;
	}
	public void setHeigthIn(Float heigthIn) {
		this.heigthIn = heigthIn;
	}
	
	
}
