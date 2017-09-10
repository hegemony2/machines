package com.toton.machines.domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public class ParentEntity {

	@Id
	//@GeneratedValue(generator = "uuid2")
	//@GenericGenerator(name = "uuid2", strategy = "uuid2")
	//@Column(columnDefinition = "BINARY(16)")
	@GeneratedValue
	@Column( columnDefinition = "uuid", updatable = false )	
	protected UUID id;
	
	@Column(nullable = false)
	protected Date created;
	
	@Column(nullable = false)
	protected Date updated;
	
	@Column(length = 256, nullable = false)
	protected String createdBy;
	
	@Column(length = 256, nullable = false)
	protected String updatedBy;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@PrePersist
	@PreUpdate
	void preUpdate() {
		String user = "username";
		Date now = new Date();
		setUpdated(now);
		setUpdatedBy(user);
		if (getCreated()==null || getId()==null) {
			setCreated(now);
			setCreatedBy(user);
		}
	}
	
}
