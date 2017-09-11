package com.toton.machines.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toton.machines.domain.AutomobileModelYear;
import com.toton.machines.service.AutomobileModelYearService;

@RestController
@RequestMapping(value="/services/AutomobileModelYear")
public class AutomobileModelYearController extends CrudController<AutomobileModelYear> {

	@Autowired
	AutomobileModelYearService automobileModelYearService;
	

}