package com.Hibernate.mapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="questions")
public class Question {
	
	@Id
	@Column(name="question_id")
	private int questionId;
	private String question;
//	@OneToOne
//	@JoinColumn(name="answer_forifen_key")
	// Eager Loading 
	@OneToMany(mappedBy="question",fetch=FetchType.EAGER)
	private List<Answer> answer;
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Question(int questionId, String question, List<Answer> answer) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answer = answer;
	}


	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}
	

}
