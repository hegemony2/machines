package com.toton.machines.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.toton.machines.domain.FuelType;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CrudServiceTest {

	@Autowired
	@InjectMocks
	CrudService<FuelType> crudService;

	@Mock
	private CrudRepository<FuelType, UUID> crudRepository;

	@Mock
	private RepositoriesService<FuelType> repositoriesService;

	private FuelType fuelType = new FuelType();
	
    @Before
    public void before() {
    	fuelType.setName("gasoline");
    	
		when(repositoriesService.getRepository(FuelType.class)).thenReturn(crudRepository);
		when(crudRepository.save(any(FuelType.class))).thenReturn(fuelType);
    }
	
	@Test
	public void create() {

		try {
			fuelType = (FuelType) crudService.create(fuelType);
		} catch (Exception e) {
			fuelType = null;
		}

		assertNotNull(fuelType);

	}

	@Test(expected = ConstraintViolationException.class)
	public void createNegative() throws Exception {

		FuelType fuelType = new FuelType();
		fuelType.setName("gasoline");

		when(crudRepository.save(fuelType)).thenThrow(ConstraintViolationException.class);

		fuelType = (FuelType) crudService.create(fuelType);

	}

}
