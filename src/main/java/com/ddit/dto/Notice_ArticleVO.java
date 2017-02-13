package com.ddit.dto;

import java.util.Date;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;
@Alias("article")
@Data
public class Notice_ArticleVO {

	private int noar_seq;
	private String noar_subject;
	private String noar_content;
	private Date noar_date;
	private String noar_id;
	private int noar_cnt;
}
