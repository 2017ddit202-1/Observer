package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.FreeBoardVO;
import com.ddit.dto.MemberVO;
import com.ddit.dto.VWmemPosVO;

public interface SuperAdminService {
	
	public void authorityUpdateMember(MemberVO memberVO)throws SQLException;
	public ArrayList<VWmemPosVO> VWmemPosMemberAll() throws SQLException;
	
	public ArrayList<VWmemPosVO> VWmemSerchId(int tpage,String mem_id) throws SQLException;
	public String pageNumberId(int tpage, String mem_id) throws SQLException;
}
