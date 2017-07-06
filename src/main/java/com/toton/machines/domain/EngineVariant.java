package com.toton.machines.domain;

//@Entity
public class EngineVariant extends ParentEntity {

	private EngineModel engineModel;
	private Integer modelYear;	
	private String designation;
	
	private Float displacement;
	
	private InductionType inductionType;
	private Boolean isIntercooled;
	private Integer inductionTypeCount;
	
	private Valvetrain valvetrain;
	
	private Integer maxHp;
	private Integer maxHpRpm;
	private Integer maxTorqueLbFt;
	private Integer maxTorqueRpm;
	
	private Integer octane;

	public EngineModel getEngineModel() {
		return engineModel;
	}

	public void setEngineModel(EngineModel engineModel) {
		this.engineModel = engineModel;
	}

	public Integer getModelYear() {
		return modelYear;
	}

	public void setModelYear(Integer modelYear) {
		this.modelYear = modelYear;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Float getDisplacement() {
		return displacement;
	}

	public void setDisplacement(Float displacement) {
		this.displacement = displacement;
	}

	public InductionType getInductionType() {
		return inductionType;
	}

	public void setInductionType(InductionType inductionType) {
		this.inductionType = inductionType;
	}

	public Boolean getIsIntercooled() {
		return isIntercooled;
	}

	public void setIsIntercooled(Boolean isIntercooled) {
		this.isIntercooled = isIntercooled;
	}

	public Integer getInductionTypeCount() {
		return inductionTypeCount;
	}

	public void setInductionTypeCount(Integer inductionTypeCount) {
		this.inductionTypeCount = inductionTypeCount;
	}

	public Valvetrain getValvetrain() {
		return valvetrain;
	}

	public void setValvetrain(Valvetrain valvetrain) {
		this.valvetrain = valvetrain;
	}

	public Integer getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(Integer maxHp) {
		this.maxHp = maxHp;
	}

	public Integer getMaxHpRpm() {
		return maxHpRpm;
	}

	public void setMaxHpRpm(Integer maxHpRpm) {
		this.maxHpRpm = maxHpRpm;
	}

	public Integer getMaxTorqueRpm() {
		return maxTorqueRpm;
	}

	public void setMaxTorqueRpm(Integer maxTorqueRpm) {
		this.maxTorqueRpm = maxTorqueRpm;
	}

	public Integer getOctane() {
		return octane;
	}

	public void setOctane(Integer octane) {
		this.octane = octane;
	}
	
	
	
	
}
