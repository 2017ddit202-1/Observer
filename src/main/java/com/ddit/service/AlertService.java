package com.ddit.service;

import java.sql.SQLException;




import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ddit.dto.AdminVO;

public interface AlertService {

	public String select_sessionID(String userid)throws SQLException;
	public void alertDelete(String userid)throws SQLException;
	public String authority_content(String userid)throws SQLException;
	

}

