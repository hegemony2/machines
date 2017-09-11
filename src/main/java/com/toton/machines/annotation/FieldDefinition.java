package com.toton.machines.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface FieldDefinition {

// label to be shown on form
	String label();
// size of html field	
	int htmlsize() default 50;
// type of html field... options = text,display,date,datetime,radio,password,hidden,textarea,view,select,keyvalue
	String htmltype() default "text";
// order in which this field shows up on the form	
	int order();
// show this field when reading form?	
	boolean showonread() default true;
// show this field when creating form?	
	boolean showoncreate() default true;
// show this field when updating form?	
	boolean showonupdate() default true;
	
	boolean showinlist() default true;
	
	// options for this field when it is radio, select...  use "@options_fieldname" to set it to a field on the form	
	String options() default "";
	
}
