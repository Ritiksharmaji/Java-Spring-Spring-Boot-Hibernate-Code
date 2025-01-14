package com.Hibernate.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddClass {

	public static void main(String[] args) {
		 Configuration cfg = new Configuration();
	        cfg.configure("hiberante.cfg.xml");
	        SessionFactory factory = cfg.buildSessionFactory();
	        System.out.println(factory);
	        
	        Student st = new Student();
	        st.setCity("guntur");
	        st.setName("Nasmine");
	        st.setId(101);
	        
	        Certificate cert = new Certificate();
	        cert.setCretificateid(201);
	        cert.setCertificatename("programming in java");
	        cert.setDuration("6 weeks");
	       // here we are passing the object of certificate to student
	       st.setCertifi(cert);
	       
// -----------OTHER OBJECT CLASS -------------------------------------
	       Student st2 = new Student();
	        st2.setCity("VIJAYWADA");
	        st2.setName("adil");
	        st2.setId(102);
	        
	        Certificate cert2 = new Certificate();
	        cert2.setCretificateid(202);
	        cert2.setCertificatename("programming in python");
	        cert2.setDuration("12 weeks");
	       // here we are passing the object of certificate to student
	       st2.setCertifi(cert2);
	       
	       // --------------to save the data by hybernate--------------
	       Session session = factory.openSession();
	       // to start the transaction
	       Transaction beginTransaction = session.beginTransaction();
	       // to save the transcation(changed)
	       session.save(st);
	       System.out.println("first object has inserted");
	       session.save(st2);
	       System.out.println("second object has inserted");
	       // to commit the database changed
	       beginTransaction.commit();
	       // close the connection
	       session.close(); 
	      
	       factory.close();

	}

}
