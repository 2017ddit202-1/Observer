package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.FreeBoardVO;
import com.ddit.dto.MemberVO;
import com.ddit.dto.VWmemPosVO;
import com.ddit.ibatis.AuthorityDAO_iBatis;
import com.ddit.ibatis.SuperAdminDAO_iBatis;

public class SuperAdminServiceImpl implements SuperAdminService {
	
	private SuperAdminDAO_iBatis superadminDAO;

	public void setSuperAdminDAO(SuperAdminDAO_iBatis superadminDAO) {
		this.superadminDAO = superadminDAO;
	}
	
	
	@Override
	public void authorityUpdateMember(MemberVO memberVO) throws SQLException {
		superadminDAO.authorityUpdateMember(memberVO);
	}


	@Override
	public ArrayList<VWmemPosVO> VWmemPosMemberAll() throws SQLException {
		return superadminDAO.VWmemPosMemberAll();
	}


	@Override
	public ArrayList<VWmemPosVO> VWmemSerchId(int tpage,String mem_id)
			throws SQLException {
		return superadminDAO.VWmemSerchId(mem_id, tpage);
	}


	@Override
	public String pageNumberId(int tpage, String mem_id) throws SQLException {	
		return superadminDAO.pageNumberId(tpage, mem_id);
	}

}
