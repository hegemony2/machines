package com.toton.machines.repositories;

import org.springframework.stereotype.Repository;

import com.toton.machines.domain.EngineModel;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;


@Repository
public interface EngineModelRepository extends CrudRepository<EngineModel, UUID> {

}
