package com.ddit.dto;

import java.util.Date;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("disk")
@Data
public class DiskVO {

	private String disk_nm;
	private String disk_total;
	private String disk_using;
	private String disk_ip;
	private int disk_seq;
	private Date disk_date;
	private String server_code;
	
}
