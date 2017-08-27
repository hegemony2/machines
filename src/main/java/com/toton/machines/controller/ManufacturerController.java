package com.toton.machines.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.toton.machines.domain.Manufacturer;
import com.toton.machines.service.ManufacturerService;

@RestController
@RequestMapping(value="/Manufacturer")
public class ManufacturerController extends CrudController<Manufacturer> {

	@Autowired
	ManufacturerService manufacturerService;
	
	@RequestMapping(value = "/getListManufacturer", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> getListManufacturer(HttpServletRequest request) {
		
		String jsonListManufacturer=null;
		HttpStatus httpStatus = HttpStatus.OK;

		try {
			jsonListManufacturer=manufacturerService.getAllJson(); 
			if (jsonListManufacturer==null) httpStatus = HttpStatus.NOT_FOUND;
		}
		catch (Exception e) {
			httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
			e.printStackTrace();
		}
		return(new ResponseEntity<String>(jsonListManufacturer, httpStatus));

	}

}