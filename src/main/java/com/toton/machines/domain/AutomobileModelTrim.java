package com.toton.machines.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.toton.machines.annotation.FieldDefinition;

@Entity
public class AutomobileModelTrim extends ParentEntity {

	@FieldDefinition(label="Trim", order=10, htmltype="text")
	private String name;

    @ManyToOne  
	@FieldDefinition(label="Automobile Model Year", order=20)
	private AutomobileModelYear automobileModelYear;
	
	@FieldDefinition(label="Passenger Volume", order=30, htmltype="text", htmlsize=5)
    private String passengerVolumeCuFt;

	@FieldDefinition(label="Cargo Volume", order=30, htmltype="text", htmlsize=5)
    private String cargoVolumeCuFt;
	
	@FieldDefinition(label="Curb Weight", order=40, htmltype="text", htmlsize=5)
    private String curbWeightLbs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AutomobileModelYear getAutomobileModelYear() {
		return automobileModelYear;
	}

	public void setAutomobileModelYear(AutomobileModelYear automobileModelYear) {
		this.automobileModelYear = automobileModelYear;
	}

	public String getPassengerVolumeCuFt() {
		return passengerVolumeCuFt;
	}

	public void setPassengerVolumeCuFt(String passengerVolumeCuFt) {
		this.passengerVolumeCuFt = passengerVolumeCuFt;
	}

	public String getCargoVolumeCuFt() {
		return cargoVolumeCuFt;
	}

	public void setCargoVolumeCuFt(String cargoVolumeCuFt) {
		this.cargoVolumeCuFt = cargoVolumeCuFt;
	}

	public String getCurbWeightLbs() {
		return curbWeightLbs;
	}

	public void setCurbWeightLbs(String curbWeightLbs) {
		this.curbWeightLbs = curbWeightLbs;
	}
	
	

	
}
