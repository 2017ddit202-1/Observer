package com.ddit.dto;

import java.util.Date;

public class ProcessVO {

	private String process_cpu;
	private String process_memory;
	private String process_cnt;
	private String process_nm;
	private String process_ip;
	private int process_seq;
	private Date process_date;
	private String server_code;
	
	
	@Override
	public String toString() {
		return "ProcessVO [process_cpu=" + process_cpu + ", process_memory="
				+ process_memory + ", process_cnt=" + process_cnt
				+ ", process_nm=" + process_nm + ", process_ip=" + process_ip
				+ ", process_seq=" + process_seq + ", process_date="
				+ process_date + ", server_code=" + server_code + "]";
	}
	public String getProcess_cpu() {
		return process_cpu;
	}
	public void setProcess_cpu(String process_cpu) {
		this.process_cpu = process_cpu;
	}
	public String getProcess_memory() {
		return process_memory;
	}
	public void setProcess_memory(String process_memory) {
		this.process_memory = process_memory;
	}
	public String getProcess_cnt() {
		return process_cnt;
	}
	public void setProcess_cnt(String process_cnt) {
		this.process_cnt = process_cnt;
	}
	public String getProcess_nm() {
		return process_nm;
	}
	public void setProcess_nm(String process_nm) {
		this.process_nm = process_nm;
	}
	public String getProcess_ip() {
		return process_ip;
	}
	public void setProcess_ip(String process_ip) {
		this.process_ip = process_ip;
	}
	public int getProcess_seq() {
		return process_seq;
	}
	public void setProcess_seq(int process_seq) {
		this.process_seq = process_seq;
	}
	public Date getProcess_date() {
		return process_date;
	}
	public void setProcess_date(Date process_date) {
		this.process_date = process_date;
	}
	public String getServer_code() {
		return server_code;
	}
	public void setServer_code(String server_code) {
		this.server_code = server_code;
	}
	
	
}
