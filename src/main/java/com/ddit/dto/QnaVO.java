package com.ddit.dto;

import java.util.Date;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;
@Alias("qna")
@Data
public class QnaVO {

	private int qseq;
	private String qna_id;
	private String qna_subject;
	private String qna_content;
	private int qna_check;
	private Date qna_date;
}
