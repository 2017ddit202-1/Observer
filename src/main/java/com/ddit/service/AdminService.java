package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.AdminVO;

public interface AdminService {

	public ArrayList<AdminVO> listAllAdmin()throws SQLException;
	public void insertAdmin(AdminVO adminVO)throws SQLException;
	public void deleteAdmin(int admin_seq)throws SQLException;
	public AdminVO select_Seq(int admin_seq)throws SQLException;
	public void updateAdmin(AdminVO adminVO)throws SQLException;
	public void nswerAdmin(AdminVO adminVO)throws SQLException;
	public ArrayList<AdminVO> nswerN()throws SQLException;
	public ArrayList<AdminVO> nswerY()throws SQLException;
	
	/*search*/
	public ArrayList<AdminVO> Search_ad_seq(int keyword)throws SQLException;
	public ArrayList<AdminVO> Search_ad_id(String keyword)throws SQLException;
	public ArrayList<AdminVO> Search_ad_subject(String keyword)throws SQLException;
	
	/*페이징*/
	public ArrayList<AdminVO> listAdminlist(int tpage,String ad_id) throws SQLException;
	public String totalAdmin(int tpage, String ad_id) throws SQLException;
}
