package com.ddit.dto;

import java.util.Date;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("notice")
@Data
public class NoticeVO {

	private int notice_seq;
	private Date notice_date;
	private String notice_dng_lv;
	private String notice_server_nm;
	private String content;
	private String notice_ip;
	private String server_code;
}
