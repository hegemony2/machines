package com.toton.machines.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toton.machines.repositories.AutomobileModelRepository;

@Service
public class AutomobileModelService {

	@Autowired
	AutomobileModelRepository automobileModelRepository;
	
}
