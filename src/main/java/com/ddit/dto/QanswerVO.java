package com.ddit.dto;

import java.util.Date;

public class QanswerVO {

	private int qans_seq;
	private String qans_content;
	private int qans_qseq;
	private String qans_id;
	private Date qans_date;
	
	
	
	@Override
	public String toString() {
		return "QanswerVO [qans_seq=" + qans_seq + ", qans_content="
				+ qans_content + ", qans_qseq=" + qans_qseq + ", qans_id="
				+ qans_id + ", qans_date=" + qans_date + "]";
	}
	public int getQans_seq() {
		return qans_seq;
	}
	public void setQans_seq(int qans_seq) {
		this.qans_seq = qans_seq;
	}
	public String getQans_content() {
		return qans_content;
	}
	public void setQans_content(String qans_content) {
		this.qans_content = qans_content;
	}
	public int getQans_qseq() {
		return qans_qseq;
	}
	public void setQans_qseq(int qans_qseq) {
		this.qans_qseq = qans_qseq;
	}
	public String getQans_id() {
		return qans_id;
	}
	public void setQans_id(String qans_id) {
		this.qans_id = qans_id;
	}
	public Date getQans_date() {
		return qans_date;
	}
	public void setQans_date(Date qans_date) {
		this.qans_date = qans_date;
	}
	
	
	
}
