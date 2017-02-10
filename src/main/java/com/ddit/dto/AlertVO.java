package com.ddit.dto;

public class AlertVO {
	private String al_authority; 
	private String al_id;
	
	
	public String getAl_authority() {
		return al_authority;
	}
	public void setAl_authority(String al_authority) {
		this.al_authority = al_authority;
	}
	public String getAl_id() {
		return al_id;
	}
	public void setAl_id(String al_id) {
		this.al_id = al_id;
	}

	
	
	@Override
	public String toString() {
		return "AlertVO [al_authority=" + al_authority + ", al_id=" + al_id
				+ "]";
	}
	
}

