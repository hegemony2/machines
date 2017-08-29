package com.toton.machines.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toton.machines.domain.FuelType;

@RestController
@RequestMapping(value="/services/FuelType")
public class FuelTypeController extends CrudController<FuelType> {


}