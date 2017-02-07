package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.Vw_AuthorityVO;
import com.ddit.ibatis.AuthorityDAO_iBatis;

public class AuthorityServiceImpl implements AuthorityService{
	
	private AuthorityDAO_iBatis authorityDAO;

	public void setAuthorityDAO(AuthorityDAO_iBatis authorityDAO) {
		this.authorityDAO = authorityDAO;
	}


	@Override
	public void AuthorityInsert(String userid) throws SQLException {
		authorityDAO.AuthorityInsert(userid);
		
	}

	@Override
	public ArrayList<Vw_AuthorityVO> authorityList() throws SQLException {
		return authorityDAO.authorityList();
	}

}
