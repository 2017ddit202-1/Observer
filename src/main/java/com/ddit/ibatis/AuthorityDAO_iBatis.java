package com.ddit.ibatis;

import java.sql.SQLException;

import com.ddit.dao.AuthorityDAO;
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

}
