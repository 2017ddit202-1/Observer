package com.ddit.ibatis;

import java.sql.SQLException;

import com.ddit.dao.AlertDAO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class AlertDAO_iBatis implements AlertDAO{
	
	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public String select_sessionID(String userid) throws SQLException {
		
		return (String)client.queryForObject("select_sessionID",userid);
	}

	@Override
	public void alertDelete(String userid) throws SQLException {
		client.delete("alertDelete",userid);
		
	}

	@Override
	public String authority_content(String userid) throws SQLException {
		return (String) client.queryForObject("authority_content",userid);
	}

}

