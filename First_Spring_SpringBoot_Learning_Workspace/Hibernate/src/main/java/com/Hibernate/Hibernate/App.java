package com.Hibernate.Hibernate;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	/*
    	 * here Configuration is class which implements the SessionFactory interface.
    	 * we are creating the object for SessionFactory interface by Configuration class 
    	 * so that SessionFactory will give the connection object .
    	 */
        Configuration cfg = new Configuration();
        cfg.configure("hiberante.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        System.out.println(factory);
        
        // creating object for class
        Student st = new Student();
       
        // setting value for class properties
        st.setId(1002);
        st.setName("Ankush sharma");
        st.setCity("bombay");
        // display values by setString method
        System.out.println(st); 
    //---------------------------------------------------------------
        // creating object for Address class
        Address address = new Address();
        address.setStreet("street1");
        address.setAddedDate(new Date());
        address.setCity("Delhi");
        address.setX(1234.234);
        //reading the image
        FileInputStream fis = new FileInputStream("src/main/resources/image/jeep3.jpeg");
       //create byte types array to store image
        byte[] data = new byte[fis.available()];
        //to set the image
        fis.read(data);
        address.setImage(data);
       
        
        // getting session
      Session session = factory.openSession();
      // to start the transaction
      Transaction beginTransaction = session.beginTransaction();
      // to save the transcation(changed)
      session.save(st);
      session.save(address);
      // to commit the database changed
      beginTransaction.commit();
      // close the connection
      session.close(); 
      System.out.println("Done");
    }
}















