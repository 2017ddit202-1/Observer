package com.ddit.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.MemberVO;
import com.ddit.dto.VWmemPosVO;

public interface SuperAdminDAO {
	
	public void authorityUpdateMember(MemberVO memberVO)throws SQLException;
	public ArrayList<VWmemPosVO> VWmemPosMemberAll() throws SQLException;
	
}
