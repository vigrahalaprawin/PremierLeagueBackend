package com.premier.springboot.database;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseLinkingService {
	
	//Added for future executions for MySql Queries like Cascading/Procedures...etc
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	//Sample execution which will not have any impact  below method.
	@PostConstruct
	public void deleteDatabase() throws IOException {
		
		String sqlScript = "ALTER TABLE premier DROP COLUMN new_column";
		jdbcTemplate.execute(sqlScript);
		
		
	}

}
