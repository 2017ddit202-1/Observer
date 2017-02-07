package com.ddit.dto;

import java.util.Date;

import java.util.Date;

public class Vw_AuthorityVO {
	private String atrt_id;
	private Date atrt_date;
	private String atrt_admin_accept;
	private String atrt_user_accept;
	private String posl_pos;

	public String getAtrt_id() {
		return atrt_id;
	}

	public void setAtrt_id(String atrt_id) {
		this.atrt_id = atrt_id;
	}

	public Date getAtrt_date() {
		return atrt_date;
	}

	public void setAtrt_date(Date atrt_date) {
		this.atrt_date = atrt_date;
	}

	public String getAtrt_admin_accept() {
		return atrt_admin_accept;
	}

	public void setAtrt_admin_accept(String atrt_admin_accept) {
		this.atrt_admin_accept = atrt_admin_accept;
	}

	public String getAtrt_user_accept() {
		return atrt_user_accept;
	}

	public void setAtrt_user_accept(String atrt_user_accept) {
		this.atrt_user_accept = atrt_user_accept;
	}

	public String getPosl_pos() {
		return posl_pos;
	}

	public void setPosl_pos(String posl_pos) {
		this.posl_pos = posl_pos;
	}

	@Override
	public String toString() {
		return "Vw_AuthorityVO [atrt_id=" + atrt_id + ", atrt_date="
				+ atrt_date + ", atrt_admin_accept=" + atrt_admin_accept
				+ ", atrt_user_accept=" + atrt_user_accept + ", posl_pos="
				+ posl_pos + "]";
	}

}
