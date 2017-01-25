package com.ddit.dto;

import java.util.Date;

public class DiskVO {

	private String disk_nm;
	private String disk_total;
	private String disk_using;
	private String disk_ip;
	private int disk_seq;
	private Date disk_date;
	private String server_code;
	
	
	@Override
	public String toString() {
		return "DiskVO [disk_nm=" + disk_nm + ", disk_total=" + disk_total
				+ ", disk_using=" + disk_using + ", disk_ip=" + disk_ip
				+ ", disk_seq=" + disk_seq + ", disk_date=" + disk_date
				+ ", server_code=" + server_code + "]";
	}
	public String getDisk_nm() {
		return disk_nm;
	}
	public void setDisk_nm(String disk_nm) {
		this.disk_nm = disk_nm;
	}
	public String getDisk_total() {
		return disk_total;
	}
	public void setDisk_total(String disk_total) {
		this.disk_total = disk_total;
	}
	public String getDisk_using() {
		return disk_using;
	}
	public void setDisk_using(String disk_using) {
		this.disk_using = disk_using;
	}
	public String getDisk_ip() {
		return disk_ip;
	}
	public void setDisk_ip(String disk_ip) {
		this.disk_ip = disk_ip;
	}
	public int getDisk_seq() {
		return disk_seq;
	}
	public void setDisk_seq(int disk_seq) {
		this.disk_seq = disk_seq;
	}
	public Date getDisk_date() {
		return disk_date;
	}
	public void setDisk_date(Date disk_date) {
		this.disk_date = disk_date;
	}
	public String getServer_code() {
		return server_code;
	}
	public void setServer_code(String server_code) {
		this.server_code = server_code;
	}
	
	
}
