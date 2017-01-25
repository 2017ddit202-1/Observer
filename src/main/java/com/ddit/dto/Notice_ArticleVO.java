package com.ddit.dto;

import java.util.Date;

public class Notice_ArticleVO {

	private int noar_seq;
	private String noar_subject;
	private String noar_content;
	private Date noar_date;
	private String noar_id;
	
	public int getNoar_seq() {
		return noar_seq;
	}
	public void setNoar_seq(int noar_seq) {
		this.noar_seq = noar_seq;
	}
	public String getNoar_subject() {
		return noar_subject;
	}
	public void setNoar_subject(String noar_subject) {
		this.noar_subject = noar_subject;
	}
	public String getNoar_content() {
		return noar_content;
	}
	public void setNoar_content(String noar_content) {
		this.noar_content = noar_content;
	}
	public Date getNoar_date() {
		return noar_date;
	}
	public void setNoar_date(Date noar_date) {
		this.noar_date = noar_date;
	}
	public String getNoar_id() {
		return noar_id;
	}
	public void setNoar_id(String noar_id) {
		this.noar_id = noar_id;
	}
	@Override
	public String toString() {
		return "Notice_ArticleVO [noar_seq=" + noar_seq + ", noar_subject="
				+ noar_subject + ", noar_content=" + noar_content
				+ ", noar_date=" + noar_date + ", noar_id=" + noar_id + "]";
	}
	
	
	
}
