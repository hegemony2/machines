package com.toton.machines.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;

@Service
public class CrudService<S> {

	@Autowired
	private WebApplicationContext webApplicationContext;

	public S create(S obj) throws Exception {

		@SuppressWarnings("unchecked")
		CrudRepository<S, UUID> crudRepository = getRepository((Class<S>) obj.getClass());
		obj = (S) crudRepository.save(obj);
		return (obj);
	}

	public S read(String className, UUID id) throws Exception {

		CrudRepository<S, UUID> crudRepository = getRepository(className);
		S obj = (S) crudRepository.findOne(id);
		return (obj);

	}

	public S update(JsonNode jsonNode, String className, UUID id) throws Exception {

		S obj = (S) read(className, id);
		return (obj);

	}
	
	public List<S> list(String className) throws Exception {

		CrudRepository<S, UUID> crudRepository = getRepository(className);
		List<S> obj = Lists.newArrayList(crudRepository.findAll());
		return (obj);

	}

	@SuppressWarnings("unchecked")
	public CrudRepository<S, UUID> getRepository(String className) {

		Repositories repositories = new Repositories(webApplicationContext);

		CrudRepository<S, UUID> crudRepository = null;

		try {
			crudRepository = (CrudRepository<S, UUID>) repositories.getRepositoryFor(Class.forName("com.toton.machines.domain." + className));
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return crudRepository;

	}

	@SuppressWarnings("unchecked")
	public CrudRepository<S, UUID> getRepository(Class<S> cls) {

		Repositories repositories = new Repositories(webApplicationContext);
		CrudRepository<S, UUID> crudRepository = (CrudRepository<S, UUID>) repositories.getRepositoryFor(cls);
		return crudRepository;

	}

}
