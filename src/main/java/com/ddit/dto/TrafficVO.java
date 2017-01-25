package com.ddit.dto;

import java.util.Date;

public class TrafficVO {

	private String traffic_ip;
	private String traffic_use;
	private String traffic_rece;
	private String traffic_trans;
	private int traffic_seq;
	private Date traffic_date;
	private String server_code;
	
	
	@Override
	public String toString() {
		return "TrafficVO [traffic_ip=" + traffic_ip + ", traffic_use="
				+ traffic_use + ", traffic_rece=" + traffic_rece
				+ ", traffic_trans=" + traffic_trans + ", traffic_seq="
				+ traffic_seq + ", traffic_date=" + traffic_date
				+ ", server_code=" + server_code + "]";
	}
	public String getTraffic_ip() {
		return traffic_ip;
	}
	public void setTraffic_ip(String traffic_ip) {
		this.traffic_ip = traffic_ip;
	}
	public String getTraffic_use() {
		return traffic_use;
	}
	public void setTraffic_use(String traffic_use) {
		this.traffic_use = traffic_use;
	}
	public String getTraffic_rece() {
		return traffic_rece;
	}
	public void setTraffic_rece(String traffic_rece) {
		this.traffic_rece = traffic_rece;
	}
	public String getTraffic_trans() {
		return traffic_trans;
	}
	public void setTraffic_trans(String traffic_trans) {
		this.traffic_trans = traffic_trans;
	}
	public int getTraffic_seq() {
		return traffic_seq;
	}
	public void setTraffic_seq(int traffic_seq) {
		this.traffic_seq = traffic_seq;
	}
	public Date getTraffic_date() {
		return traffic_date;
	}
	public void setTraffic_date(Date traffic_date) {
		this.traffic_date = traffic_date;
	}
	public String getServer_code() {
		return server_code;
	}
	public void setServer_code(String server_code) {
		this.server_code = server_code;
	}
	
	
	
}
