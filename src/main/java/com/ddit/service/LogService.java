package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.LogVO;

public interface LogService {

	public int insertCpu(LogVO logVO) throws SQLException;
	public void updateCpu(LogVO logVO) throws SQLException;
	public int deleteCpu(int log_seq) throws SQLException;
	LogVO selectCpu(int log_seq) throws SQLException;
	public ArrayList<LogVO> listAllArticle() throws SQLException;
}
