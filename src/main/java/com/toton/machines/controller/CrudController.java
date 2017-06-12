package com.toton.machines.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.toton.machines.service.CrudService;

@RestController
public class CrudController<S> {

	@Autowired
	CrudService<S> crudService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<S> create(@RequestBody S obj) {

		S savedObj=null;
		HttpStatus httpStatus = HttpStatus.CREATED;

		try {
			savedObj = (S) crudService.create(obj);
		}
		catch (Exception e) {
			httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
			e.printStackTrace();
		}
		return(new ResponseEntity<S>(savedObj, httpStatus));
		
	}
	
	@RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
	public ResponseEntity<S> read(HttpServletRequest request, @PathVariable UUID id) {
		
		S obj=null;
		HttpStatus httpStatus = HttpStatus.OK;

		try {
			obj = (S) crudService.read(getClassName(request), id);
			if (obj==null) httpStatus = HttpStatus.NOT_FOUND;
		}
		catch (Exception e) {
			httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
			e.printStackTrace();
		}
		return(new ResponseEntity<S>(obj, httpStatus));
		
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<S> update(HttpServletRequest request, @RequestBody JsonNode obj, @PathVariable UUID id) {

		S savedObj=null;
		HttpStatus httpStatus = HttpStatus.CREATED;

		try {
			savedObj = (S) crudService.update(obj, getClassName(request), id);
		}
		catch (Exception e) {
			httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
			e.printStackTrace();
		}
		return(new ResponseEntity<S>(savedObj, httpStatus));
		
	}
	
	private String getClassName(HttpServletRequest request) {
		
		String requestUrl = request.getRequestURL().toString();
		requestUrl=requestUrl.substring(0, requestUrl.indexOf("/read/"));
		return(requestUrl.substring(requestUrl.lastIndexOf("/")+1));
		
	}

}