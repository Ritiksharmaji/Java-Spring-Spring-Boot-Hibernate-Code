package com.Hibernate.Hibernate;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {
	
	private int cretificateid;
	private String certificatename;
	private String duration;
	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Certificate(int cretificateid, String certificatename, String duration) {
		super();
		this.cretificateid = cretificateid;
		this.certificatename = certificatename;
		this.duration = duration;
	}
	public int getCretificateid() {
		return cretificateid;
	}
	public void setCretificateid(int cretificateid) {
		this.cretificateid = cretificateid;
	}
	public String getCertificatename() {
		return certificatename;
	}
	public void setCertificatename(String certificatename) {
		this.certificatename = certificatename;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	

}
