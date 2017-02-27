package com.ddit.dto;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("ServerInfo")
@Data
public class ServerInfoVO {
	String server_host;
	String server_ip;
	String server_os_name;
	double cpu_total_pcnt;
	String memory_total;
	
	
	
}
