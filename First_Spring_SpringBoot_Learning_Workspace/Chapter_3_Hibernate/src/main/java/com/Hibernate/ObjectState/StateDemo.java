package com.Hibernate.ObjectState;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.Hibernate.Hibernate.Certificate;
import com.Hibernate.Hibernate.Student;

public class StateDemo {
	public static void main(String[] args) {
		/*	Practical on Object states
			Transient , Persistent , Detached , and Removed
		 */
		System.out.println("Example of Object states flow");
		  SessionFactory factory =  new Configuration().configure("hiberante.cfg.xml").buildSessionFactory();
		  
		   /*
		    *	creating object and storing properties values to store object to 
		   	*	Transient state.
		    */
		  Student st = new Student();
		  st.setId(101);
		  st.setName("nitesh sharma");
		  st.setCity("vijaywada");
		  st.setCertifi(new Certificate(30,"learn the Hadoop","3 months"));
		  /*
		   * creating Session to stored object to session object and database.
		   * 
		   */
		  Session s = factory.openSession();
		  Transaction beginTransaction = s.beginTransaction();
		  s.save(st);
		// to commit the database changed
		  st.setName("abhi boss ji");
	      beginTransaction.commit();
	      
	      s.close();
	      st.setName("ankit sharma");
	      /*here this data will not stored in database but it will stored in
	       * session object
	       */
	      System.out.println(st.getName());
	      
		  
		  

	}

}
