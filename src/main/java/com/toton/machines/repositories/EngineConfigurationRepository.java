package com.toton.machines.repositories;

import org.springframework.stereotype.Repository;

import com.toton.machines.domain.EngineConfiguration;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;


@Repository
public interface EngineConfigurationRepository extends CrudRepository<EngineConfiguration, UUID> {

}
