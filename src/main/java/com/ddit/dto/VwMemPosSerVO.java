package com.ddit.dto;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("vwVO")
@Data
public class VwMemPosSerVO {

	private String mem_id;
	private String mem_nm;
	private String mem_email;
	private String posl_pos;
	private String mem_group_lice;
	private String server_ip;
}
