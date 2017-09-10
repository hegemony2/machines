package com.toton.machines.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.toton.machines.domain.AutomobileModel;


@Repository
public interface AutomobileModelRepository extends CrudRepository<AutomobileModel, UUID> {

	@Override
	@Query("select am from AutomobileModel am order by am.manufacturer.name, am.name")
	public List<AutomobileModel> findAll();
	
}
