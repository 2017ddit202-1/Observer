package com.ddit.dao;

import java.sql.SQLException;

public interface AlertDAO {
	
	public String select_sessionID(String userid)throws SQLException;
	public void alertDelete(String userid)throws SQLException;

}
