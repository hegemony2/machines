package com.toton.machines.service;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.toton.machines.dto.schema.Entity;

@Service
public class RepositoriesService<S> {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private SchemaService schemaService;
	

//	public String schema(String className) throws Exception {
	public Entity schema(String className) throws Exception {

		String fullClassName = "com.toton.machines.domain." + className;
		
//		String obj = null;
//		ObjectMapper mapper = new ObjectMapper();
//		// configure mapper, if necessary, then create schema generator
//		JsonSchemaGenerator schemaGen = new JsonSchemaGenerator(mapper);
//		JsonSchema schema = schemaGen.generateSchema(Class.forName(fullClassName));
//		obj = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(schema);
//		return (obj);
		
		return(schemaService.getSchema(fullClassName));
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
	
	
	public String getClassName(HttpServletRequest request) {
		
		String requestUrl = request.getRequestURL().toString();
		String host = request.getRemoteHost();
		int hostpos = request.getRequestURL().indexOf(host);
		int slashpos = request.getRequestURL().indexOf("/", hostpos + host.length());
		slashpos = request.getRequestURL().indexOf("/", slashpos + 1);		
		int nextslashpos = request.getRequestURL().indexOf("/", slashpos + 1);
		String className = requestUrl.substring(slashpos + 1, nextslashpos);
		return(className);
		
	}

}
