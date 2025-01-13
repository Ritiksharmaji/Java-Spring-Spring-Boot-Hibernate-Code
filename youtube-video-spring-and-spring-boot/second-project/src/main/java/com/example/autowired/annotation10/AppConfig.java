package com.example.autowired.annotation10;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// to define this class as configuration we are using the @Configuration
@Configuration
// to load the configuration from the different package we are using the @ComponentScan
@ComponentScan(basePackages="com.example.autowired.annotation10")
public class AppConfig {
	
	

}
