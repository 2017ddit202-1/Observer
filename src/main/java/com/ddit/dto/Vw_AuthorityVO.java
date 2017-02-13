package com.ddit.dto;

import java.util.Date;
import java.util.Date;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;
@Alias("superAdmin")
@Data
public class Vw_AuthorityVO {
	private String atrt_id;
	private Date atrt_date;
	private String atrt_admin_accept;
	private String atrt_user_accept;
	private String posl_pos;

}
