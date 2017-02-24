package com.ddit.dto;

import java.util.Date;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("admin")
@Data

public class AdminVO {
	
	private int admin_seq;
	private int ad_check;
	private String ad_content;
	private String ad_subject;
	private String ad_id;
	private Date ad_date;
	private String ad_nswer;
	
}
