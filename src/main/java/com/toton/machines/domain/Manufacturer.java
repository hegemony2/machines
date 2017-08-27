package com.toton.machines.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Manufacturer extends ParentEntity {

	@Column(unique=true)
	private String name;

    @OneToMany  
	private List<AutomobileModel> listAutomobileModel;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AutomobileModel> getListAutomobileModel() {
		return listAutomobileModel;
	}

	public void setListAutomobileModel(List<AutomobileModel> listAutomobileModel) {
		this.listAutomobileModel = listAutomobileModel;
	}


	
}
