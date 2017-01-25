package com.ddit.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.LogVO;

public interface LogDAO {

	public int insertLog(LogVO logVO) throws SQLException;
	public void updateLog(LogVO logVO) throws SQLException;
	public int deleteLog(int log_seq) throws SQLException;
	LogVO selectLog(int log_seq) throws SQLException;
	public ArrayList<LogVO> listAllArticle() throws SQLException;
}
