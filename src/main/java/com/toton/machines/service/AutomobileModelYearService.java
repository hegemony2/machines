package com.toton.machines.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toton.machines.repositories.AutomobileModelYearRepository;

@Service
public class AutomobileModelYearService {

	@Autowired
	AutomobileModelYearRepository automobileModelYearRepository;
	
}
