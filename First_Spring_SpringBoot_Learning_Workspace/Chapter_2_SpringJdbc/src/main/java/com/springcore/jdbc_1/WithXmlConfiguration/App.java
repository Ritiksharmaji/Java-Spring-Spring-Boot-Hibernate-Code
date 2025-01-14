package com.springcore.jdbc_1.WithXmlConfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("program is start....");
        // spring jdbc=> jdbcTemplate
        ApplicationContext context=	new ClassPathXmlApplicationContext("com/springcore/jdbc_1/WithXmlConfiguration/config.xml");       
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        
        // insert query
        String query = "insert into student(id,name,city)values(?,?,?)";
        
        // fire the query
        int result = jdbcTemplate.update(query,105,"priyanshu sharma", "hydrabad");
        System.out.println(result);
        
     
    }
}



