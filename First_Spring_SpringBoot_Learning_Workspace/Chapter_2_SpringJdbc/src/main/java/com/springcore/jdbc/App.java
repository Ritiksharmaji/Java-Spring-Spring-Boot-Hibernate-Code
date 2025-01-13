package com.springcore.jdbc;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.Dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("program is start....");
        // spring jdbc=> jdbcTemplate
       // here we commited the xml configuration
        //ApplicationContext context=	new ClassPathXmlApplicationContext("com/springcore/jdbc/config.xml");       
        
        ApplicationContext context=	new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao temp =  context.getBean("studentDao1",StudentDao.class);
        
        // for Update data into database....
        Student student = new Student();
        student.setId(111);
        student.setName("rahul kumar");
        student.setCity("hasanpura");
        int insertData = temp.insert(student);
        //int changed = temp.change(student);
        System.out.println("student inserted: "+ insertData);
        
        // for delete
//        int deleted = temp.delete(101);
//        System.out.println("data deleted: "+ deleted);
//        
        // for select single record
//        Student ss = temp.getStudent(110);
//        System.out.println();
        
     // for selecting multiple record
        List<Student> sts = temp.getStudents();
        for(Student s: sts) {
        	System.out.println(s);
        }
    }
}



