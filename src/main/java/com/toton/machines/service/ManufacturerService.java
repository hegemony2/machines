package com.toton.machines.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toton.machines.repositories.CustomQueryRepository;
import com.toton.machines.repositories.ManufacturerRepository;

@Service
public class ManufacturerService {

	@Autowired
	ManufacturerRepository manufacturerRepository;
	
	@Autowired
	CustomQueryRepository customQueryRepository;
	
	public String getAllJson() {
		
		String sql = "" +
				"select array_to_json(array_agg(row_to_json(t))) " + 
				"from ( " + 
				"	select " + 
				"    manufacturer_name " + 
				"	,manufacturer_id " + 
				"    ,array_to_json(array_agg(json_build_object('automobile_model_name', automobile_model_name, 'automobile_model_id', automobile_model_id))) as list_automobile_model " + 
				"    from " + 
				"        (select  " + 
				"        m.name as manufacturer_name " + 
				"        ,m.id as manufacturer_id " + 
				"        ,am.name as automobile_model_name " + 
				"        ,am.id as automobile_model_id " + 
				"        from manufacturer m " + 
				"        left join automobile_model am on am.manufacturer_id = m.id " + 
				"        order by m.name, am.name " + 
				"        ) models " + 
				"    group by manufacturer_name, manufacturer_id " + 
				"    order by manufacturer_name, manufacturer_id " +				
				") t " 
				+ "";
		String json = customQueryRepository.jsonQuery(sql);
		return(json);
		
	}
	
}
