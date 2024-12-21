package com.springcore.spEL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Demo {
	@Value("#{20+30}")
	private int x;
	@Value("#{40+40}")
	private int y;
	@Value("#{T(java.lang.Math).sqrt(25)}")
	private int z;
	// to print the object type 
	@Value("#{new java.lang.String('Ritik sharma')}")
	private String name;
	@Value("#{4>2}")
	private boolean isActive;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		System.out.println("value of z by static method sqrt():");
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	@Override
	public String toString() {
		return "Demo [x=" + x + ", y=" + y + ", z=" + z + ", name=" + name + ", isActive=" + isActive + "]";
	}
	
	
	
}
