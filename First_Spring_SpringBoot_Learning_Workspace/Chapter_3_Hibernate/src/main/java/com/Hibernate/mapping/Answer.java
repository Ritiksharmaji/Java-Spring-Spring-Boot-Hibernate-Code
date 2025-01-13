package com.Hibernate.mapping;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Answers")
public class Answer {
	
	@Id
	@Column(name="answer_id")
	private int answerid;
	private String answer;
	
	//@OneToOne(mappedBy="answer")
	// to change the name of forgine key name
	@ManyToOne
	@JoinColumn(name="question_forifen_key")
	private Question question;
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Answer(int answerid, String answer, Question question) {
		super();
		this.answerid = answerid;
		this.answer = answer;
		this.question = question;
	}

	public int getAnswerid() {
		return answerid;
	}
	public void setAnswerid(int answerid) {
		this.answerid = answerid;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	

}
