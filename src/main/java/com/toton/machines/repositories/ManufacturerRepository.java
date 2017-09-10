package com.toton.machines.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.toton.machines.domain.Manufacturer;


@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, UUID> {

	@Query(value=
			"" +
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
			") t " 
			+ "", nativeQuery=true)
	String listManufacturerAndModels();
	
	@Override
	@Query("select m from Manufacturer m order by m.name")
	public List<Manufacturer> findAll();
	
	
}
