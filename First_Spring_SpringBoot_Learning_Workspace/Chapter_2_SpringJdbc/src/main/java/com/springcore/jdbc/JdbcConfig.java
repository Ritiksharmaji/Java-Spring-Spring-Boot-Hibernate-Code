package com.springcore.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.Dao.StudentDao;
import com.spring.jdbc.Dao.StudentDaoIm;

@Configuration
@ComponentScan(basePackages= {"com.spring.jdbc.Dao"})
public class JdbcConfig {
	
	// this method is for DriverManagerDataSource class to create object for DataSource interface
	// and return it
	@Bean("ds")
	public DataSource getDataSource_R() {
		// creating the object for DataSource interface.
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		// setting the properties
		//datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		datasource.setPassword("Ritiksharma620@");
		datasource.setUsername("root");
		// returing the datasource object
		return datasource;	
	}
	
	// creating method for retuing the object of JdbcTemplate class
	@Bean("jdbcTemplate")
	public JdbcTemplate getjdbcTemplate() {
		
		JdbcTemplate jdbcTemplateObject = new JdbcTemplate();
		// calling the DataSource object which return the datasource details.
		jdbcTemplateObject.setDataSource(getDataSource_R());
		return jdbcTemplateObject;
		
	}
	// creating object for StudentDao class
//	@Bean("studentDao1")
//	public StudentDao getstudentDao() {
//		
//		StudentDaoIm studentdaobject = new StudentDaoIm();
//		studentdaobject.setJdbctemplate(getjdbcTemplate());
//		return studentdaobject;
//		
//	}

}
