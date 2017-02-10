package com.ddit.service;


import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.AlertVO;
import com.ddit.dto.AuthorityVO;
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


	@Override
	public String authoritySelect1(String userid) throws SQLException {
		return authorityDAO.authoritySelect1(userid);
	}


	@Override
	public void adminAuthority(String userid) throws SQLException {
		authorityDAO.adminAuthority(userid);
		
	}


	@Override
	public void authorityDelete(String userid) throws SQLException {
		authorityDAO.authorityDelete(userid);
		
	}


	@Override
	public void userAuthority(String userid) throws SQLException {
		authorityDAO.userAuthority(userid);
		
	}


	@Override
	public AuthorityVO authorityYN(String userid) throws SQLException {
		return authorityDAO.authorityYN(userid);
		
	}


	@Override
	public void alertY_insert(AlertVO alertVO) throws SQLException {
		authorityDAO.alertY_insert(alertVO);
		
	}


	@Override
	public void authorityRejection(String userid) throws SQLException {
		authorityDAO.authorityRejection(userid);
		
	}



}
