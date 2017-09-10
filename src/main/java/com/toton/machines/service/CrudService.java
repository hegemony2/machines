package com.toton.machines.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;
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

	public S update(S obj, String className, UUID id) throws Exception {

		@SuppressWarnings("unchecked")
		CrudRepository<S, UUID> crudRepository = getRepository((Class<S>) obj.getClass());
		obj = (S) crudRepository.save(obj);
		return (obj);

	}
	
	public void delete(String className, UUID id) throws Exception {

		CrudRepository<S, UUID> crudRepository = getRepository(className);
		crudRepository.delete(id);

	}

	public List<S> list(String className) throws Exception {

		CrudRepository<S, UUID> crudRepository = getRepository(className);
		List<S> obj = Lists.newArrayList(crudRepository.findAll());
		return (obj);

	}

	public String schema(String className) throws Exception {

		String obj = null;

		ObjectMapper mapper = new ObjectMapper();
		// configure mapper, if necessary, then create schema generator
		JsonSchemaGenerator schemaGen = new JsonSchemaGenerator(mapper);
		JsonSchema schema = schemaGen.generateSchema(Class.forName("com.toton.machines.domain." + className));
		obj = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(schema);
		return (obj);

	}

	@SuppressWarnings("unchecked")
	public CrudRepository<S, UUID> getRepository(String className) {

		Repositories repositories = new Repositories(webApplicationContext);

		CrudRepository<S, UUID> crudRepository = null;

		try {
			crudRepository = (CrudRepository<S, UUID>) repositories
					.getRepositoryFor(Class.forName("com.toton.machines.domain." + className));
		} catch (ClassNotFoundException e) {
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
