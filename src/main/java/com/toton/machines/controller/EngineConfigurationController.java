package com.toton.machines.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.toton.machines.domain.EngineConfiguration;
import com.toton.machines.service.EngineConfigurationService;

@RestController
@RequestMapping(value="/engineconfiguration")
public class EngineConfigurationController extends CrudController<EngineConfiguration> {


}