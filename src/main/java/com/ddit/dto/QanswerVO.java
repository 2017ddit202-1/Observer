package com.ddit.dto;

import java.util.Date;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;
@Alias("qans")
@Data
public class QanswerVO {

	private int qans_seq;
	private String qans_content;
	private int qans_qseq;
	private String qans_id;
	private Date qans_date;
	
}
