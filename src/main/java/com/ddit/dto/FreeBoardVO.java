package com.ddit.dto;

import java.util.Date;

public class FreeBoardVO {

	private int fb_seq;
	private String fb_subject;
	private String fb_content;
	private int fb_cnt;
	private Date fb_date;
	private String fb_id;
	
	
	@Override
	public String toString() {
		return "FreeBoardVO [fb_seq=" + fb_seq + ", fb_subject=" + fb_subject
				+ ", fb_content=" + fb_content + ", fb_cnt=" + fb_cnt
				+ ", fb_date=" + fb_date + ", fb_id=" + fb_id + "]";
	}
	public int getFb_seq() {
		return fb_seq;
	}
	public void setFb_seq(int fb_seq) {
		this.fb_seq = fb_seq;
	}
	public String getFb_subject() {
		return fb_subject;
	}
	public void setFb_subject(String fb_subject) {
		this.fb_subject = fb_subject;
	}
	public String getFb_content() {
		return fb_content;
	}
	public void setFb_content(String fb_content) {
		this.fb_content = fb_content;
	}
	public int getFb_cnt() {
		return fb_cnt;
	}
	public void setFb_cnt(int fb_cnt) {
		this.fb_cnt = fb_cnt;
	}
	public Date getFb_date() {
		return fb_date;
	}
	public void setFb_date(Date fb_date) {
		this.fb_date = fb_date;
	}
	public String getFb_id() {
		return fb_id;
	}
	public void setFb_id(String fb_id) {
		this.fb_id = fb_id;
	}
	
	
}
