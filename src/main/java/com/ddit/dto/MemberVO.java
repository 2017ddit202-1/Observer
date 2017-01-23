package com.ddit.dto;

import java.sql.Date;

public class MemberVO {
	private String id;
	private String pwd;
	private String nm;
	private String email;
	private String phone;
	private String wtd;
	private Date date;
	private String mem_group_lice;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWtd() {
		return wtd;
	}
	public void setWtd(String wtd) {
		this.wtd = wtd;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMem_group_lice() {
		return mem_group_lice;
	}
	public void setMem_group_lice(String mem_group_lice) {
		this.mem_group_lice = mem_group_lice;
	}
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", nm=" + nm
				+ ", email=" + email + ", phone=" + phone + ", wtd=" + wtd
				+ ", date=" + date + ", mem_group_lice=" + mem_group_lice + "]";
	}
	
	
	
}
