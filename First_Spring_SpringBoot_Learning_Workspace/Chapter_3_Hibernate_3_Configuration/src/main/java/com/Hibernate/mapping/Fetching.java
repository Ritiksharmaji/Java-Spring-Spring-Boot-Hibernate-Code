package com.Hibernate.mapping;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Fetching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration cfg = new Configuration();
        cfg.configure("hiberante.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        System.out.println(factory);
        
     // getting session
        Session session = factory.openSession();
        // to start the transaction
        Transaction beginTransaction = session.beginTransaction();
        // to save the transaction(changed)
        Question question = session.get(Question.class,12 );
        
        System.out.println(question.getQuestionId());
        System.out.println(question.getQuestion());
//        //lazy loading
//        System.out.println(question.getAnswer());
        
     // to commit the database changed
        beginTransaction.commit();

	}

}
