package com.toton.machines.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomQueryRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
	
	public String jsonQuery(String sql) {
		
		String result = (String) jdbcTemplate.queryForObject(sql, String.class);
		return(result);
	}
	
}
