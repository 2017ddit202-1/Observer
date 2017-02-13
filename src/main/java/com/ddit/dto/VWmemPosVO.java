package com.ddit.dto;

import java.util.Date;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;
@Alias("VWmempos")
@Data
public class VWmemPosVO {
	String posl_pos;
	String mem_group_lice;
	String mem_pwd;
	String mem_nm;
	String mem_email;
	String mem_phone;
	int enabled;
	Date mem_date;
	String mem_id;
}


