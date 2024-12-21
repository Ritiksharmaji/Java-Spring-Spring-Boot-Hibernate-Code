package com.Hibernate.mapping;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		
		 Configuration cfg = new Configuration();
	        cfg.configure("hiberante.cfg.xml");
	        SessionFactory factory = cfg.buildSessionFactory();
	        System.out.println(factory);
// --------- creating first object-------------------------------	        
	        Question q = new Question();
	        q.setQuestionId(12);
	        q.setQuestion("what is c langauge");
	        
	        Answer ans = new Answer();
	        ans.setAnswerid(104);
	        ans.setAnswer("a basic programming language");
	        ans.setQuestion(q);
	        
	        Answer ans2 = new Answer();
	        ans2.setAnswerid(105);
	        ans2.setAnswer("a basic programming language");
	        ans2.setQuestion(q);
	        
	        Answer ans3 = new Answer();
	        ans3.setAnswerid(106);
	        ans3.setAnswer("is powerfull language for computer ");
	        ans3.setQuestion(q);
	        
	        List<Answer> list = new ArrayList<>();
	        list.add(ans);
	        list.add(ans2);
	        list.add(ans3);
	        
	        q.setAnswer(list);
	        
	     // getting session
	        Session session = factory.openSession();
	        // to start the transaction
	        Transaction beginTransaction = session.beginTransaction();
	        // to save the transaction(changed)
	        session.save(q);
	        System.out.println("-----------question data stored in DB--------------");
	        
	        session.save(ans);       
	        session.save(ans2);
	        session.save(ans3);
	        System.out.println("-----------answer data stored in DB--------------");
	        // to commit the database changed
	        beginTransaction.commit();
	 //printing some question and answer
	        Question question = session.get(Question.class,12 );
	        System.out.println(question.getQuestion());
	        //System.out.println(question.getAnswer().getAnswer());
	        for(Answer an: q.getAnswer()) {
	        	System.out.println(an.getAnswer());
	        }
	        // close the connection
	        session.close(); 
	        System.out.println("Done");

	}

}
