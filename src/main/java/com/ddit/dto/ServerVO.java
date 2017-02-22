package com.ddit.dto;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("server")
@Data
public class ServerVO {

	private String server_host;
	private String server_os_version;
	private String server_ip;
	private String server_id;
	private String server_code;
	private String saveyn;
	private String server_os_name;
	private String server_os_support;
}
