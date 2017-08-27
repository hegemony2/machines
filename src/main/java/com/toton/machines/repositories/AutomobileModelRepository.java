package com.toton.machines.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.toton.machines.domain.AutomobileModel;


@Repository
public interface AutomobileModelRepository extends CrudRepository<AutomobileModel, UUID> {

	
	
}
