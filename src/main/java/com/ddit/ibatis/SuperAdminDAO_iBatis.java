package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.SuperAdminDAO;
import com.ddit.dto.MemberVO;
import com.ddit.dto.VWmemPosVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class SuperAdminDAO_iBatis implements SuperAdminDAO {
	
	private SqlMapClient client;
	 public void setClient(SqlMapClient client){
		 this.client=client;
	 }
	
	@Override
	public void authorityUpdateMember(MemberVO memberVO) throws SQLException {
		client.update("authorityUpdateMember", memberVO);
	}

	@Override
	public ArrayList<VWmemPosVO> VWmemPosMemberAll() throws SQLException {
		return (ArrayList<VWmemPosVO>) client.queryForList("VWmemPosMemberAll");
	}

}
