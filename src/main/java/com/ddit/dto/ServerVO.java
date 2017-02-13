package com.ddit.dto;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("server")
@Data
public class ServerVO {

	private String server_host;
	private String server_os;
	private String server_ip;
	private String server_id;
	private String server_code;
}
