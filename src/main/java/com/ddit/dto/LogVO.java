package com.ddit.dto;

import java.util.Date;

public class LogVO {

	private String log_info;
	private String log_ip;
	private int log_seq;
	private Date log_date;
	private String log_lv;
	private String Server_code;
	
	
	@Override
	public String toString() {
		return "LogVO [log_info=" + log_info + ", log_ip=" + log_ip
				+ ", log_seq=" + log_seq + ", log_date=" + log_date
				+ ", log_lv=" + log_lv + ", Server_code=" + Server_code + "]";
	}
	public String getLog_info() {
		return log_info;
	}
	public void setLog_info(String log_info) {
		this.log_info = log_info;
	}
	public String getLog_ip() {
		return log_ip;
	}
	public void setLog_ip(String log_ip) {
		this.log_ip = log_ip;
	}
	public int getLog_seq() {
		return log_seq;
	}
	public void setLog_seq(int log_seq) {
		this.log_seq = log_seq;
	}
	public Date getLog_date() {
		return log_date;
	}
	public void setLog_date(Date log_date) {
		this.log_date = log_date;
	}
	public String getLog_lv() {
		return log_lv;
	}
	public void setLog_lv(String log_lv) {
		this.log_lv = log_lv;
	}
	public String getServer_code() {
		return Server_code;
	}
	public void setServer_code(String server_code) {
		Server_code = server_code;
	}
	
	
	
}
