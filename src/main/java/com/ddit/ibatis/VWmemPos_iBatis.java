package com.ddit.ibatis;

import java.sql.SQLException;

import com.ddit.dao.VWmemPosDAO;
import com.ddit.dto.VWmemPosVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class VWmemPos_iBatis implements VWmemPosDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	
	
	
	@Override
	public VWmemPosVO memposVO(String id) throws SQLException {
		VWmemPosVO memposVO = (VWmemPosVO)client.queryForObject("VWmemposVO", id);
		System.out.println("()()()DATA ACESS OBJECT()()()");
		return memposVO;
	}
	
}
