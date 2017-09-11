package com.toton.machines.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.toton.machines.domain.AutomobileModelYear;


@Repository
public interface AutomobileModelYearRepository extends CrudRepository<AutomobileModelYear, UUID> {

	@Override
	@Query("select amy from AutomobileModelYear amy order by amy.automobileModel.manufacturer.name, amy.automobileModel.name, amy.name")
	public List<AutomobileModelYear> findAll();
	
}
