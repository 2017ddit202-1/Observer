package com.ddit.service;

import java.sql.SQLException;

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

}
