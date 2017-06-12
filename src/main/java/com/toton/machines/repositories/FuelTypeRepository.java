package com.toton.machines.repositories;

import org.springframework.stereotype.Repository;

import com.toton.machines.domain.FuelType;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;


@Repository
public interface FuelTypeRepository extends CrudRepository<FuelType, UUID> {

}
