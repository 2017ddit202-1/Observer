package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.ProcessVO;

public interface ProcessService {

	public int insertProcess(ProcessVO ProcessVO) throws SQLException;
	public void updateProcess(ProcessVO ProcessVO) throws SQLException;
	public int deleteProcess(String process_cpu) throws SQLException;
	ProcessVO selectProcess(String process_cpu) throws SQLException;
	public ArrayList<ProcessVO> listAllArticle() throws SQLException;
}
