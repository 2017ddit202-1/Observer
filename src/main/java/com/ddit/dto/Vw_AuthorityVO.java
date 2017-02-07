package com.ddit.dto;

import java.util.Date;

public class Vw_AuthorityVO {
	private String atrt_id; 
	private Date atrt_date; 
	private String atrt_accept; 
	private String posl_pos;
	
	public String getAtrt_id() {
		return atrt_id;
	}
	public void setAtrt_id(String atrt_id) {
		this.atrt_id = atrt_id;
	}
	public Date getAtrt_date() {
		return atrt_date;
	}
	public void setAtrt_date(Date atrt_date) {
		this.atrt_date = atrt_date;
	}
	public String getAtrt_accept() {
		return atrt_accept;
	}
	public void setAtrt_accept(String atrt_accept) {
		this.atrt_accept = atrt_accept;
	}
	public String getPosl_pos() {
		return posl_pos;
	}
	public void setPosl_pos(String posl_pos) {
		this.posl_pos = posl_pos;
	}
	
	@Override
	public String toString() {
		return "Vw_AuthorityVO [atrt_id=" + atrt_id + ", atrt_date="
				+ atrt_date + ", atrt_accept=" + atrt_accept + ", posl_pos="
				+ posl_pos + "]";
	} 
	
	
	

}
