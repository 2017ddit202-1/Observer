package com.ddit.dto;

import java.sql.Date;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;
@Alias("member")
@Data
public class MemberVO {
   private String mem_id;
   private String mem_pwd;
   private String mem_nm;
   private String mem_email;
   private String mem_phone;
   private int enabled;
   private Date mem_date;
   private String mem_group_lice;
}