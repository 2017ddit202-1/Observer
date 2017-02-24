package com.ddit.dto;

import java.util.Date;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("memo")
@Data
public class MemoryVO {

	private String memory_total;
	private String memory_using;
	private String memory_ip;
	private int memory_seq;
	private Date memory_date;
	private String server_code;
	private String memory_idle;
	private String memory_total_used;
}
