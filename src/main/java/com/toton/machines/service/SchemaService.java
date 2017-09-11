package com.toton.machines.service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Service;

import com.toton.machines.annotation.FieldDefinition;
import com.toton.machines.dto.schema.Entity;

@Service
public class SchemaService {

	public Entity getSchema(String className) {

		String basePackage = "com.toton.machines.domain";

		Entity entity = new Entity();

		try {

			Class<?> klazz = Class.forName(className);

			entity.setType(klazz.getSimpleName());
			entity.setId(klazz.getCanonicalName());

			Class<?> currentKlazz = klazz;
			Field[] fields = null;

			while (currentKlazz != null) {
				fields = ArrayUtils.addAll(fields, currentKlazz.getDeclaredFields());
				currentKlazz = currentKlazz.getSuperclass();
			}

			Map<String, Entity> properties = new HashMap<String, Entity>();

			for (Field field : fields) {

				String fieldType = field.getType().getName();

				Entity property = null;

				if (fieldType.indexOf(basePackage) > -1) {
					property = getSchema(fieldType);
				} else {
					property = new Entity();
					property.setType(field.getType().getSimpleName());
				}

				property.setFieldDefinition(getAnnotationValues(field, field.getDeclaredAnnotation(FieldDefinition.class)));
				properties.put(field.getName(), property);

			}
			
			if (!properties.isEmpty()) {
		        
		        entity.setProperties(sortHashMap(properties));
		        
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return (entity);

	}

	private Map<String, String> getAnnotationValues(Field field, Annotation annotation) {

		Map<String, String> fieldDefinitionMap = new HashMap<String, String>();
		
		if (annotation != null) {

			Class<? extends Annotation> type = annotation.annotationType();
			System.out.println("Values of " + type.getName());

			for (Method method : type.getDeclaredMethods()) {
				Object value;
				try {
					value = method.invoke(annotation, (Object[]) null);
					fieldDefinitionMap.put(method.getName(), value + "");					
				} 
				catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}

			}

		}

	
		return(fieldDefinitionMap);
	}
	
	private Map<String, Entity> sortHashMap(Map<String, Entity> properties) {
		
		Comparator<Entry<String, Entity>> valueComparator = new Comparator<Entry<String,Entity>>() { 
			@Override public int compare(Entry<String, Entity> e1, Entry<String, Entity> e2) { 
				String v1 = "0";
				if (e1.getValue().getFieldDefinition()!=null) {
					if (e1.getValue().getFieldDefinition().get("order")!=null) {
						v1=e1.getValue().getFieldDefinition().get("order");
					}
				}
				String v2 = "0";
				if (e2.getValue().getFieldDefinition()!=null) {
					if (e2.getValue().getFieldDefinition().get("order")!=null) {
						v2=e2.getValue().getFieldDefinition().get("order");
					}
				}				
				return v1.compareTo(v2); 
			} 
		};
		
        Set<Entry<String, Entity>> entries = properties.entrySet();
		List<Entry<String, Entity>> listOfEntries = new ArrayList<Entry<String, Entity>>(entries);
        Collections.sort(listOfEntries, valueComparator);
		
        Map<String, Entity> sortedByValue = new LinkedHashMap<String, Entity>(listOfEntries.size());
        for(Entry<String, Entity> entry : listOfEntries) { 
        	sortedByValue.put(entry.getKey(), entry.getValue()); 
    	}
	
		return(sortedByValue);
        
	}

}
