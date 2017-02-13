package com.ddit.dto;

import java.util.Date;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;
import lombok.Getter;

@Alias("freeBoard")
@Data
public class FreeBoardVO {

	private int fb_seq;
	private String fb_subject;
	private String fb_content;
	private int fb_cnt;
	private Date fb_date;
	private String fb_id;
}
