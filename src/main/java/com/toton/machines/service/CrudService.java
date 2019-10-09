package com.toton.machines.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

@Service
public class CrudService<S> {

	@Autowired
	private RepositoriesService<S> repositoriesService;
	
	public S create(S obj) throws Exception {

		@SuppressWarnings("unchecked")
		CrudRepository<S, UUID> crudRepository = repositoriesService.getRepository((Class<S>) obj.getClass());
		obj = (S) crudRepository.save(obj);
		return (obj);
	}

	public S read(String className, UUID id) throws Exception {

		CrudRepository<S, UUID> crudRepository = repositoriesService.getRepository(className);
		S obj = (S) crudRepository.findOne(id);
		return (obj);

	}

	public S update(S obj, String className, UUID id) throws Exception {

		@SuppressWarnings("unchecked")
		CrudRepository<S, UUID> crudRepository = repositoriesService.getRepository((Class<S>) obj.getClass());
		obj = (S) crudRepository.save(obj);
		return (obj);

	}
	
	public void delete(String className, UUID id) throws Exception {

		CrudRepository<S, UUID> crudRepository = repositoriesService.getRepository(className);
		crudRepository.delete(id);

	}

	public List<S> list(String className) throws Exception {

		CrudRepository<S, UUID> crudRepository = repositoriesService.getRepository(className);
		List<S> obj = Lists.newArrayList(crudRepository.findAll());
		return (obj);

	}

}
