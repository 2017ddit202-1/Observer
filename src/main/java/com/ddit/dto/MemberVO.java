package com.ddit.dto;

import java.sql.Date;

public class MemberVO {
   private String mem_id;
   private String mem_pwd;
   private String mem_nm;
   private String mem_email;
   private String mem_phone;
   private int enabled;
   private Date mem_date;
   private String mem_group_lice;
   
   
   public int getEnabled() {
      return enabled;
   }
   public void setEnabled(int enabled) {
      this.enabled = enabled;
   }
   public String getMem_id() {
      return mem_id;
   }
   public void setMem_id(String mem_id) {
      this.mem_id = mem_id;
   }
   public String getMem_pwd() {
      return mem_pwd;
   }
   public void setMem_pwd(String mem_pwd) {
      this.mem_pwd = mem_pwd;
   }
   public String getMem_nm() {
      return mem_nm;
   }
   public void setMem_nm(String mem_nm) {
      this.mem_nm = mem_nm;
   }
   public String getMem_email() {
      return mem_email;
   }
   public void setMem_email(String mem_email) {
      this.mem_email = mem_email;
   }
   public String getMem_phone() {
      return mem_phone;
   }
   public void setMem_phone(String mem_phone) {
      this.mem_phone = mem_phone;
   }
   public Date getMem_date() {
      return mem_date;
   }
   public void setMem_date(Date mem_date) {
      this.mem_date = mem_date;
   }
   public String getMem_group_lice() {
      return mem_group_lice;
   }
   public void setMem_group_lice(String mem_group_lice) {
      this.mem_group_lice = mem_group_lice;
   }
   @Override
   public String toString() {
      return "MemberVO [mem_id=" + mem_id + ", mem_pwd=" + mem_pwd
            + ", mem_nm=" + mem_nm + ", mem_email=" + mem_email
            + ", mem_phone=" + mem_phone + ", enabled=" + enabled
            + ", mem_date=" + mem_date + ", mem_group_lice="
            + mem_group_lice + "]";
   }
   

   
   
   
}