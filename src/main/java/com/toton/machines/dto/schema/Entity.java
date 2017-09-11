package com.toton.machines.dto.schema;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Entity {

	private String type;
	private String id;
	private String format;
	private Map<String, Entity> properties;
	private Map<String, String> fieldDefinition;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public Map<String, Entity> getProperties() {
		return properties;
	}
	public void setProperties(Map<String, Entity> properties) {
		this.properties = properties;
	}
	public Map<String, String> getFieldDefinition() {
		return fieldDefinition;
	}
	public void setFieldDefinition(Map<String, String> fieldDefinition) {
		this.fieldDefinition = fieldDefinition;
	}

	
}
