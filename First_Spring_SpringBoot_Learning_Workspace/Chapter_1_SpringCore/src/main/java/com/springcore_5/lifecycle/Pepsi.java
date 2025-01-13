package com.springcore_5.lifecycle;
//importing the InitializingBean from BeanFactroy
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

// implementing the this two method in user-define class.
public class Pepsi implements InitializingBean,DisposableBean {
	private double price;

	// defalut constructor
	public Pepsi() {
		super();
	}

	@Override
	public String toString() {
		return "Pepsi [price=" + price + "]";
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	// method of InitializingBean interface which works as inti() method 
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		// init
		System.out.println("this is init method of InitializingBean: Pepsi ");	
	}
	// method of DisposableBean interface which works as destroy method
	@Override
	public void destroy() throws Exception {
		// destroy
		System.out.println("this is destroy method DisposableBean : Pepsi");
		
	}

	
	
	

}
