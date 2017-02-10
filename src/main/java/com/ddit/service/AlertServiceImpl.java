package com.ddit.service;

import java.sql.SQLException;

import com.ddit.ibatis.AlertDAO_iBatis;

public class AlertServiceImpl implements AlertService{
	
	private AlertDAO_iBatis alertDAO;

	public void setAlertDAO(AlertDAO_iBatis alertDAO) {
		this.alertDAO = alertDAO;
	}

	@Override
	public String select_sessionID(String userid) throws SQLException {
		return alertDAO.select_sessionID(userid);
	}

	@Override
	public void alertDelete(String userid) throws SQLException {
		alertDAO.alertDelete(userid);
		
	}

}
