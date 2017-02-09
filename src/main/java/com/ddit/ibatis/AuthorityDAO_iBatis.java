package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.AuthorityDAO;
import com.ddit.dto.AlertVO;
import com.ddit.dto.AuthorityVO;
import com.ddit.dto.Vw_AuthorityVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class AuthorityDAO_iBatis implements AuthorityDAO {

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public void AuthorityInsert(String userid) throws SQLException {
		client.insert("AuthorityInsert", userid);

	}

	@Override
	public ArrayList<Vw_AuthorityVO> authorityList() throws SQLException {

		return (ArrayList<Vw_AuthorityVO>) client.queryForList("authorityList");

	}

	@Override
	public String authoritySelect1(String userid) throws SQLException {
		return (String) client.queryForObject("authoritySelect1",userid);
		
	}

	@Override
	public void adminAuthority(String userid) throws SQLException {
		client.update("adminAuthority",userid);
		
	}

	@Override
	public void authorityDelete(String userid) throws SQLException {
		client.delete("authorityDelete",userid);
		
	}

	@Override
	public void userAuthority(String userid) throws SQLException {
		client.update("userAuthority",userid);
		
	}

	@Override
	public AuthorityVO authorityYN(String userid) throws SQLException {
		return (AuthorityVO) client.queryForObject("authorityYN",userid);
		
	}

	@Override
	public void alertY_insert(AlertVO alertVO) throws SQLException {
		client.insert("alertY_insert",alertVO);
		
	}



}
