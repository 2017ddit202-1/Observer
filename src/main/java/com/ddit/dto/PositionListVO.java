package com.ddit.dto;

public class PositionListVO {

	private String posl_id;
	private String posl_pos;
	
	
	@Override
	public String toString() {
		return "PositionListVO [posl_id=" + posl_id + ", posl_pos=" + posl_pos
				+ "]";
	}
	public String getPosl_id() {
		return posl_id;
	}
	public void setPosl_id(String posl_id) {
		this.posl_id = posl_id;
	}
	public String getPosl_pos() {
		return posl_pos;
	}
	public void setPosl_pos(String posl_pos) {
		this.posl_pos = posl_pos;
	}
	
	
}
