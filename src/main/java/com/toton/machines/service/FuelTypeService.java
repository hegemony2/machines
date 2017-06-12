package com.toton.machines.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toton.machines.domain.FuelType;
import com.toton.machines.repositories.FuelTypeRepository;

@Service
public class FuelTypeService {

	@Autowired
	FuelTypeRepository fuelTypeRepository;
	
	
}
