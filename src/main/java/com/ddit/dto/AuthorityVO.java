package com.ddit.dto;

import java.util.Date;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("authority")
@Data
public class AuthorityVO {

	private String atrt_id;
	private Date atrt_date;
	private String atrt_admin_accept;
	private String atrt_user_accept;
	
}



