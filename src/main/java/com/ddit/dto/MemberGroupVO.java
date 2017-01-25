package com.ddit.dto;

import java.util.Date;

public class MemberGroupVO {

	private String mg_nm;
	private String mg_loce;
	private Date mg_date;
	private String mem_id;
	
	
	@Override
	public String toString() {
		return "Member_group [mg_nm=" + mg_nm + ", mg_loce=" + mg_loce
				+ ", mg_date=" + mg_date + ", mem_id=" + mem_id + "]";
	}
	public String getMg_nm() {
		return mg_nm;
	}
	public void setMg_nm(String mg_nm) {
		this.mg_nm = mg_nm;
	}
	public String getMg_loce() {
		return mg_loce;
	}
	public void setMg_loce(String mg_loce) {
		this.mg_loce = mg_loce;
	}
	public Date getMg_date() {
		return mg_date;
	}
	public void setMg_date(Date mg_date) {
		this.mg_date = mg_date;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	
}
