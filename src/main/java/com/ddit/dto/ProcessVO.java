package com.ddit.dto;

import java.util.Date;

import kr.or.ddit.commons.ibatis.Alias;
@Alias("process")
public class ProcessVO {

	private String process_cpu;
	private String process_memory;
	private String process_cnt;
	private String process_nm;
	private String process_ip;
	private int process_seq;
	private Date process_date;
	private String server_code;
	
}
