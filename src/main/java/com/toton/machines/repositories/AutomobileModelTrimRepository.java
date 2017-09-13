package com.toton.machines.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.toton.machines.domain.AutomobileModelTrim;


@Repository
public interface AutomobileModelTrimRepository extends CrudRepository<AutomobileModelTrim, UUID> {

}
