package com.springcore.removeXMl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
	
	// creating object for smosa by method
	@Bean
	public Smosa getSomosa() {
		System.out.println("------ this is getsmosa of javaConfig----------");
		return new Smosa();
	}
	
	@Bean(name= {"student","temp","con"})
	public Student getStudent() {
		// creating the Student object
		Student s1 = new Student(getSomosa());
		// returing the student object s1
		return s1;
	}

}
