package org.mars.springjdbc.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:database.properties")
@ComponentScan("org.mars.springjdbc")
public class AppConfig { //3
	@Autowired
	Environment env;
	
	@Bean
	DataSource datsor() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName(env.getProperty("driver"));
		dmds.setUrl(env.getProperty("url"));
		dmds.setUsername(env.getProperty("dbuser"));
		dmds.setPassword(env.getProperty("dbpassword"));		
		return dmds;
	
	}

}
