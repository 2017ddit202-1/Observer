package com.ddit.dto;

import java.util.Date;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

import org.springframework.web.multipart.MultipartFile;
@Alias("reference")
@Data
public class ReferenceLibrayVO {

	private int reli_seq;
	private String reli_file_nm;
	private String reli_subject;
	private Date reli_date;
	private String mem_id;
	private String reli_content;
	private Long reli_size;
	private String reli_stored_filenm;

}
