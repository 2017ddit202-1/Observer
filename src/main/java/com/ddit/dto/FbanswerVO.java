package com.ddit.dto;

import java.util.Date;

public class FbanswerVO {

	private int fbans_seq;
	private String fbans_content;
	private int fbans_fbseq;
	private String fbans_id;
	private Date fbans_date;
	
	
	@Override
	public String toString() {
		return "FbanswerVO [fbans_seq=" + fbans_seq + ", fbans_content="
				+ fbans_content + ", fbans_fbseq=" + fbans_fbseq
				+ ", fbans_id=" + fbans_id + ", fbans_date=" + fbans_date + "]";
	}
	public int getFbans_seq() {
		return fbans_seq;
	}
	public void setFbans_seq(int fbans_seq) {
		this.fbans_seq = fbans_seq;
	}
	public String getFbans_content() {
		return fbans_content;
	}
	public void setFbans_content(String fbans_content) {
		this.fbans_content = fbans_content;
	}
	public int getFbans_fbseq() {
		return fbans_fbseq;
	}
	public void setFbans_fbseq(int fbans_fbseq) {
		this.fbans_fbseq = fbans_fbseq;
	}
	public String getFbans_id() {
		return fbans_id;
	}
	public void setFbans_id(String fbans_id) {
		this.fbans_id = fbans_id;
	}
	public Date getFbans_date() {
		return fbans_date;
	}
	public void setFbans_date(Date fbans_date) {
		this.fbans_date = fbans_date;
	}
	
	
	
	
	
}
