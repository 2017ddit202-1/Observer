package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.MemoryVO;

public interface MemoryService {
	
	public int insertMemory(MemoryVO memoryVO) throws SQLException;
	public void updateMemory(MemoryVO memoryVO) throws SQLException;
	public int deleteMemory(int memory_seq) throws SQLException;
	MemoryVO selectMemory(int memory_seq) throws SQLException;
	
	public ArrayList<MemoryVO> listMemory(String ip) throws SQLException;
	public ArrayList<MemoryVO> listMemoryHo(String ip) throws SQLException;
}

