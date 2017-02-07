package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.AuthorityDAO;
import com.ddit.dto.Vw_AuthorityVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class AuthorityDAO_iBatis implements AuthorityDAO{
	
	private SqlMapClient client;
	public void setClient(SqlMapClient client) {
		this.client = client;
	}


	@Override
	public void AuthorityInsert(String userid) throws SQLException {
		client.insert("AuthorityInsert",userid);
		
	}


	@Override
	public ArrayList<Vw_AuthorityVO> authorityList() throws SQLException {
		
		System.out.println((ArrayList<Vw_AuthorityVO>) client.queryForList("authorityList"));
		return (ArrayList<Vw_AuthorityVO>) client.queryForList("authorityList");
		
	}

}
