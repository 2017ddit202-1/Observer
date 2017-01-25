package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.MemoryVO;

public interface MemoryService {
	
	public int insertCpu(MemoryVO cpuVO) throws SQLException;
	public void updateCpu(MemoryVO cpuVO) throws SQLException;
	public int deleteCpu(int memory_seq) throws SQLException;
	MemoryVO selectCpu(int memory_seq) throws SQLException;
	public ArrayList<MemoryVO> listAllArticle() throws SQLException;
}

