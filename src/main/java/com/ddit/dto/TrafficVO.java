package com.ddit.dto;

import java.util.Date;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;
@Alias("traffic")
@Data
public class TrafficVO {

	private String traffic_ip;
	private String traffic_use;
	private String traffic_rece;
	private String traffic_trans;
	private int traffic_seq;
	private Date traffic_date;
	private String server_code;
	private String traffic_net;
	
}
