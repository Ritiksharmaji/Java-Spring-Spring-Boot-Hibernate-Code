package com.springcore.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Example {
	
	private String subject;

	public Example() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return this.subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@PostConstruct
	public void start() {
		System.out.println("init method of Example bean:");
	}
	@PreDestroy
	public void end() {
		System.out.println("destroy method of Example bean:");
	}
	

}
