package com.ddit.dto;

public class ServerVO {

	private String server_host;
	private String server_os;
	private String server_ip;
	private String server_id;
	private String server_code;
	
	
	
	@Override
	public String toString() {
		return "ServerVO [server_host=" + server_host + ", server_os="
				+ server_os + ", server_ip=" + server_ip + ", server_id="
				+ server_id + ", server_code=" + server_code + "]";
	}
	public String getServer_host() {
		return server_host;
	}
	public void setServer_host(String server_host) {
		this.server_host = server_host;
	}
	public String getServer_os() {
		return server_os;
	}
	public void setServer_os(String server_os) {
		this.server_os = server_os;
	}
	public String getServer_ip() {
		return server_ip;
	}
	public void setServer_ip(String server_ip) {
		this.server_ip = server_ip;
	}
	public String getServer_id() {
		return server_id;
	}
	public void setServer_id(String server_id) {
		this.server_id = server_id;
	}
	public String getServer_code() {
		return server_code;
	}
	public void setServer_code(String server_code) {
		this.server_code = server_code;
	}
	
	
}
