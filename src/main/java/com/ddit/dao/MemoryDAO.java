package com.ddit.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.MemoryVO;

public interface MemoryDAO {

	public int insertMemory(MemoryVO MemoryVO) throws SQLException;
	public void updateMemory(MemoryVO MemoryVO) throws SQLException;
	public int deleteMemory(int memory_seq) throws SQLException;
	MemoryVO selectMemory(int memory_seq) throws SQLException;
	public ArrayList<MemoryVO> listAllArticle() throws SQLException;
}