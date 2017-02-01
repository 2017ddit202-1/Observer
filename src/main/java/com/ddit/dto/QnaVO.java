package com.ddit.dto;

import java.util.Date;

public class QnaVO {

	private int qseq;
	private String qna_id;
	private String qna_subject;
	private String qna_content;
	private int qna_check;
	public int getQna_check() {
		return qna_check;
	}
	public void setQna_check(int qna_check) {
		this.qna_check = qna_check;
	}
	private Date qna_date;
	
	
	public int getQseq() {
		return qseq;
	}
	public void setQseq(int qseq) {
		this.qseq = qseq;
	}
	public String getQna_id() {
		return qna_id;
	}
	public void setQna_id(String qna_id) {
		this.qna_id = qna_id;
	}
	public String getQna_subject() {
		return qna_subject;
	}
	public void setQna_subject(String qna_subject) {
		this.qna_subject = qna_subject;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public Date getQna_date() {
		return qna_date;
	}
	public void setQna_date(Date qna_date) {
		this.qna_date = qna_date;
	}

	
	
	
}
