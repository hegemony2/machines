package com.toton.machines.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toton.machines.domain.AutomobileModelTrim;

@RestController
@RequestMapping(value="/services/AutomobileModelTrim")
public class AutomobileModelTrimController extends CrudController<AutomobileModelTrim> {


}