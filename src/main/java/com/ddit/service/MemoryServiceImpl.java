package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.MemoryDAO;
import com.ddit.dto.MemoryVO;
import com.ddit.ibatis.MemoryDAO_iBatis;

public class MemoryServiceImpl implements MemoryService{

	

	MemoryDAO_iBatis memoryDAO_iBatis;

	public void setMemoryDAO_iBatis(MemoryDAO_iBatis memoryDAO_iBatis) {
		this.memoryDAO_iBatis = memoryDAO_iBatis;
	}

	
	@Override
	public String selectMemoryTotal(String ip) throws SQLException {
		 String momoryTotal = memoryDAO_iBatis.selectMemoryTotal(ip);
		return momoryTotal;
	}
	
	
	@Override
	public int insertMemory(MemoryVO memoryVO) throws SQLException {
		memoryDAO_iBatis.insertMemory(memoryVO);
		return 0;
	}

	@Override
	public void updateMemory(MemoryVO memoryVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteMemory(int memory_seq) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemoryVO selectMemory(int memory_seq) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MemoryVO> listMemory(String ip) throws SQLException {
		return memoryDAO_iBatis.listMemory(ip);
	}

	@Override
	public ArrayList<MemoryVO> listMemoryHo(String ip) throws SQLException {
		return memoryDAO_iBatis.listMemoryHo(ip);
	}


}
