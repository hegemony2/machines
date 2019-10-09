package com.toton.machines.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class DataSourceConfig {

	@Bean
	@Primary
	public DataSource dataSource() {
	    return DataSourceBuilder.create().build();
	}

	
}
