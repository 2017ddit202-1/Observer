package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.LogDAO;
import com.ddit.dto.LogVO;

public class LogDAO_iBatis implements LogDAO{

	@Override
	public int insertLog(LogVO logVO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateLog(LogVO logVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteLog(int log_seq) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LogVO selectLog(int log_seq) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<LogVO> listAllArticle() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
