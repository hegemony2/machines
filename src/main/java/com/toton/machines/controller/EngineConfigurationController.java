package com.toton.machines.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toton.machines.domain.EngineConfiguration;

@RestController
@RequestMapping(value="/EngineConfiguration")
public class EngineConfigurationController extends CrudController<EngineConfiguration> {


}