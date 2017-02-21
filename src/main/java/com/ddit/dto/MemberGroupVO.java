package com.ddit.dto;

import java.util.Date;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("mg")
@Data
public class MemberGroupVO {

	private String mg_nm;
	private String mg_lice;
	private Date mg_date;
	private String mem_id;
}