package com.ddit.dto;

import java.util.Date;

public class MemoryVO {

	private String memory_total;
	private String memory_using;
	private String memory_ip;
	private int memory_seq;
	private Date memory_date;
	private String server_code;
	
	
	@Override
	public String toString() {
		return "MemoryVO [memory_total=" + memory_total + ", memory_using="
				+ memory_using + ", memory_ip=" + memory_ip + ", memory_seq="
				+ memory_seq + ", memory_date=" + memory_date
				+ ", server_code=" + server_code + "]";
	}
	public String getMemory_total() {
		return memory_total;
	}
	public void setMemory_total(String memory_total) {
		this.memory_total = memory_total;
	}
	public String getMemory_using() {
		return memory_using;
	}
	public void setMemory_using(String memory_using) {
		this.memory_using = memory_using;
	}
	public String getMemory_ip() {
		return memory_ip;
	}
	public void setMemory_ip(String memory_ip) {
		this.memory_ip = memory_ip;
	}
	public int getMemory_seq() {
		return memory_seq;
	}
	public void setMemory_seq(int memory_seq) {
		this.memory_seq = memory_seq;
	}
	public Date getMemory_date() {
		return memory_date;
	}
	public void setMemory_date(Date memory_date) {
		this.memory_date = memory_date;
	}
	public String getServer_code() {
		return server_code;
	}
	public void setServer_code(String server_code) {
		this.server_code = server_code;
	}
	
	
}
