package com.springcore.springCore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext context = new ClassPathXmlApplicationContext("Configure_spring.xml");
        /*
         * The ApplicationContext interface create a context spring container.
         * 
         */
        First first = (First)context.getBean("student1");
        First second = (First)context.getBean("student2");
         System.out.println(first);
         System.out.println(second);
    }
    
    
    
    
}
