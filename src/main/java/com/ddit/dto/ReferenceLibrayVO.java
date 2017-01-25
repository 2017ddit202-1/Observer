package com.ddit.dto;

import java.util.Date;

public class ReferenceLibrayVO {

	private int reli_seq;
	private String reli_file_nm;
	private String reli_subject;
	private Date reli_date;
	private String mem_id;
	
	
	@Override
	public String toString() {
		return "ReferenceLibrayVO [reli_seq=" + reli_seq + ", reli_file_nm="
				+ reli_file_nm + ", reli_subject=" + reli_subject
				+ ", reli_date=" + reli_date + ", mem_id=" + mem_id + "]";
	}
	public int getReli_seq() {
		return reli_seq;
	}
	public void setReli_seq(int reli_seq) {
		this.reli_seq = reli_seq;
	}
	public String getReli_file_nm() {
		return reli_file_nm;
	}
	public void setReli_file_nm(String reli_file_nm) {
		this.reli_file_nm = reli_file_nm;
	}
	public String getReli_subject() {
		return reli_subject;
	}
	public void setReli_subject(String reli_subject) {
		this.reli_subject = reli_subject;
	}
	public Date getReli_date() {
		return reli_date;
	}
	public void setReli_date(Date reli_date) {
		this.reli_date = reli_date;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	
	
}
