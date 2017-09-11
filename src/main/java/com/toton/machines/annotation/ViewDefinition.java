package com.toton.machines.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ViewDefinition {

// label shown in view	
	String label();

// pixel width of column
	String size();
	
// how column is sized - 'absolute' or 'relative'	
	String sizingdefinition() default "absolute";
	
}
