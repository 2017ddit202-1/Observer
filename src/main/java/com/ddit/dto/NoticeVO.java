package com.ddit.dto;

import java.util.Date;

public class NoticeVO {

	private int notice_seq;
	private Date notice_date;
	private String notice_dng_lv;
	private String notice_server_nm;
	private String content;
	private String notice_ip;
	private String server_code;
	
	
	@Override
	public String toString() {
		return "Notice [notice_seq=" + notice_seq + ", notice_date="
				+ notice_date + ", notice_dng_lv=" + notice_dng_lv
				+ ", notice_server_nm=" + notice_server_nm + ", content="
				+ content + ", notice_ip=" + notice_ip + ", server_code="
				+ server_code + "]";
	}
	public int getNotice_seq() {
		return notice_seq;
	}
	public void setNotice_seq(int notice_seq) {
		this.notice_seq = notice_seq;
	}
	public Date getNotice_date() {
		return notice_date;
	}
	public void setNotice_date(Date notice_date) {
		this.notice_date = notice_date;
	}
	public String getNotice_dng_lv() {
		return notice_dng_lv;
	}
	public void setNotice_dng_lv(String notice_dng_lv) {
		this.notice_dng_lv = notice_dng_lv;
	}
	public String getNotice_server_nm() {
		return notice_server_nm;
	}
	public void setNotice_server_nm(String notice_server_nm) {
		this.notice_server_nm = notice_server_nm;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNotice_ip() {
		return notice_ip;
	}
	public void setNotice_ip(String notice_ip) {
		this.notice_ip = notice_ip;
	}
	public String getServer_code() {
		return server_code;
	}
	public void setServer_code(String server_code) {
		this.server_code = server_code;
	}
	
	
}
