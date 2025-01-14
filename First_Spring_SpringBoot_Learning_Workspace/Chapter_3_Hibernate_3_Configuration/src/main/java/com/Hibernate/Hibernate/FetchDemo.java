package com.Hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
public class FetchDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
        cfg.configure("hiberante.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        System.out.println(factory);
        Session session= factory.openSession();
        // get by id
        System.out.println("------------data of student class--------------------");
        Student student = (Student) session.load(Student.class, 1001 );
        //System.out.println(student);
        Student student1 = (Student) session.load(Student.class, 1001 );
       // System.out.println(student1);
        //---------------------------------------------------------
        System.out.println("------------data of student_address--------------------");
        Address address = session.get(Address.class, 1);
       // System.out.println(address);
        Address address1 = session.get(Address.class, 1);
       // System.out.println(address1);
       // System.out.println(address1.getCity());
        
        session.close();
        factory.close();

	}

}
