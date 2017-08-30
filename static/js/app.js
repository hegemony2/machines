var automobilesApp = angular.module('automobilesApp', ['ngRoute']);

function getFieldEditability(mode, property, data) {
	
	var editability = (mode=="read") ? "read" : "edit";
	
	var readOnlyFields=["id","updated","created","updatedBy","createdBy"];
	if (readOnlyFields.indexOf(property)>-1) editability="read";
	
	return(editability);
	
	
}

function getFieldType(mode, property, data) {
	
	var type = "text";
	if (data.type=="integer" && data.format=="utc-millisec") type = "datetime";
	if (data.type=="object") type="object";
	
	return(type);
	
	
}
