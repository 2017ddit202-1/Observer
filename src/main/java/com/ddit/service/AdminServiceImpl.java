package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.AdminVO;
import com.ddit.dto.Notice_ArticleVO;
import com.ddit.ibatis.AdminDAO_iBatis;
import com.ddit.ibatis.AlertDAO_iBatis;

public class AdminServiceImpl implements AdminService{

	private AdminDAO_iBatis adminDAO;


	
	public void setAdminDAO(AdminDAO_iBatis adminDAO) {
		this.adminDAO = adminDAO;
	}

	@Override
	public ArrayList<AdminVO> listAllAdmin() throws SQLException {
		ArrayList<AdminVO> adminVO = null;
		adminVO=adminDAO.listAllAdmin();
		return adminVO;
	}

	@Override
	public void insertAdmin(AdminVO adminVO) throws SQLException {
		adminDAO.insertAdmin(adminVO);
		
	}

	@Override
	public void deleteAdmin(int admin_seq) throws SQLException {
		adminDAO.deleteAdmin(admin_seq);
		
	}

	@Override
	public AdminVO select_Seq(int admin_seq) throws SQLException {
		AdminVO adminVO = adminDAO.select_Seq(admin_seq);
		return adminVO;
	}

	@Override
	public void updateAdmin(AdminVO adminVO) throws SQLException {
		adminDAO.updateAdmin(adminVO);
		
	}

	@Override
	public void nswerAdmin(AdminVO adminVO) throws SQLException {
		adminDAO.nswerAdmin(adminVO);
		
	}

	@Override
	public ArrayList<AdminVO> nswerN() throws SQLException {
		ArrayList<AdminVO> adminVO = null;
		adminVO=adminDAO.nswerN();
		return adminVO;
	}

	@Override
	public ArrayList<AdminVO> nswerY() throws SQLException {
		ArrayList<AdminVO> adminVO = null;
		adminVO=adminDAO.nswerY();
		return adminVO;
	}

	@Override
	public ArrayList<AdminVO> Search_ad_seq(int keyword) throws SQLException {
		ArrayList<AdminVO> adminVO = null;
		adminVO=adminDAO.Search_ad_seq(keyword);
		return adminVO;
	}

	@Override
	public ArrayList<AdminVO> Search_ad_id(String keyword) throws SQLException {
		ArrayList<AdminVO> adminVO = null;
		adminVO=adminDAO.Search_ad_id(keyword);
		return adminVO;
	}

	@Override
	public ArrayList<AdminVO> Search_ad_subject(String keyword) throws SQLException {
		ArrayList<AdminVO> adminVO = null;
		adminVO=adminDAO.Search_ad_subject(keyword);
		return adminVO;
	}

	@Override
	public ArrayList<AdminVO> listAdminlist(int tpage, String ad_id)
			throws SQLException {
		ArrayList<AdminVO> list = adminDAO.listAdminlist(tpage, ad_id);
		return list;
	}

	@Override
	public String totalAdmin(int tpage, String ad_id) throws SQLException {
		String str = adminDAO.totalAdmin(tpage, ad_id);
		return str;
	}


	

}
