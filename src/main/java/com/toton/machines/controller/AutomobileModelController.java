package com.toton.machines.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toton.machines.domain.AutomobileModel;
import com.toton.machines.service.AutomobileModelService;

@RestController
@RequestMapping(value="/services/AutomobileModel")
public class AutomobileModelController extends CrudController<AutomobileModel> {

	@Autowired
	AutomobileModelService automobileModelService;
	

}