package com.ddit.dto;

import java.util.Date;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("fbAns")
@Data
public class FbanswerVO {

	private int fbans_seq;
	private String fbans_content;
	private int fbans_fbseq;
	private String fbans_id;
	private Date fbans_date;
	
}
