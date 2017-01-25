package com.ddit.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.ProcessVO;

public interface ProcessDAO {

	public int insertProcess(ProcessVO ProcessVO) throws SQLException;
	public void updateProcess(ProcessVO ProcessVO) throws SQLException;
	public int deleteProcess(String process_cpu) throws SQLException;
	ProcessVO selectProcess(String process_cpu) throws SQLException;
	public ArrayList<ProcessVO> listAllArticle() throws SQLException;
}
