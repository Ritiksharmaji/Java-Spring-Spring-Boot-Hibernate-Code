package com.example.component.annotation_9;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// to define this class as configuration we are using the @Configuration
@Configuration
// to load the configuration from the different package we are using the @ComponentScan
@ComponentScan(basePackages="com.example.component.annotation_9")
public class AppConfig {
	
	

}
