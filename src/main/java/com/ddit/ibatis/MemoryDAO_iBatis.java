package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.MemoryDAO;
import com.ddit.dto.MemoryVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class MemoryDAO_iBatis implements MemoryDAO{
	
	private SqlMapClient client;
	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	
	
	@Override
	public int insertMemory(MemoryVO MemoryVO) throws SQLException {
		client.insert("insertMemoryVO" ,MemoryVO);
		return 0;
	}

	@Override
	public void updateMemory(MemoryVO MemoryVO) throws SQLException {
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
	public ArrayList<MemoryVO> listAllArticle() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
