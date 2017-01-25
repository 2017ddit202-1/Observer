package com.ddit.dto;

import java.util.Date;

public class CpuVO {

	private String cpu_pcnt;
	private String cpu_user_pcnt;
	private String cpu_total_pcnt;
	private String cpu_idle;
	private String cpu_ip;
	private int Cpu_seq;
	private Date cpu_date;
	private String server_code;
	
	@Override
	public String toString() {
		return "CpuVO [cpu_pcnt=" + cpu_pcnt + ", cpu_user_pcnt="
				+ cpu_user_pcnt + ", cpu_total_pcnt=" + cpu_total_pcnt
				+ ", cpu_idle=" + cpu_idle + ", cpu_ip=" + cpu_ip
				+ ", Cpu_seq=" + Cpu_seq + ", cpu_date=" + cpu_date
				+ ", server_code=" + server_code + "]";
	}
	public String getCpu_pcnt() {
		return cpu_pcnt;
	}
	public void setCpu_pcnt(String cpu_pcnt) {
		this.cpu_pcnt = cpu_pcnt;
	}
	public String getCpu_user_pcnt() {
		return cpu_user_pcnt;
	}
	public void setCpu_user_pcnt(String cpu_user_pcnt) {
		this.cpu_user_pcnt = cpu_user_pcnt;
	}
	public String getCpu_total_pcnt() {
		return cpu_total_pcnt;
	}
	public void setCpu_total_pcnt(String cpu_total_pcnt) {
		this.cpu_total_pcnt = cpu_total_pcnt;
	}
	public String getCpu_idle() {
		return cpu_idle;
	}
	public void setCpu_idle(String cpu_idle) {
		this.cpu_idle = cpu_idle;
	}
	public String getCpu_ip() {
		return cpu_ip;
	}
	public void setCpu_ip(String cpu_ip) {
		this.cpu_ip = cpu_ip;
	}
	public int getCpu_seq() {
		return Cpu_seq;
	}
	public void setCpu_seq(int cpu_seq) {
		Cpu_seq = cpu_seq;
	}
	public Date getCpu_date() {
		return cpu_date;
	}
	public void setCpu_date(Date cpu_date) {
		this.cpu_date = cpu_date;
	}
	public String getServer_code() {
		return server_code;
	}
	public void setServer_code(String server_code) {
		this.server_code = server_code;
	}
	
	
	
}
