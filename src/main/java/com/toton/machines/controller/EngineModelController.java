package com.toton.machines.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toton.machines.domain.EngineModel;

@RestController
@RequestMapping(value="/EngineModel")
public class EngineModelController extends CrudController<EngineModel> {

}