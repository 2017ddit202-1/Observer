package com.ddit.dto;

import java.util.Date;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("cpu")
@Data
public class CpuVO {

	private String cpu_pcnt;
	private String cpu_user_pcnt;
	private String cpu_total_pcnt;
	private String cpu_idle;
	private String cpu_ip;
	private int Cpu_seq;
	private Date cpu_date;
	private String server_code;
	
}
