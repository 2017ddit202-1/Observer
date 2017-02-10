package com.ddit.service;

import java.sql.SQLException;

public interface AlertService {

	public String select_sessionID(String userid)throws SQLException;
	public void alertDelete(String userid)throws SQLException;

}
