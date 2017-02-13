package com.ddit.dto;

import java.util.Date;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("log")
@Data
public class LogVO {

	private String log_info;
	private String log_ip;
	private int log_seq;
	private Date log_date;
	private String log_lv;
	private String Server_code;
	
}
