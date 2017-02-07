package com.ddit.service;

import java.sql.SQLException;

import com.ddit.dao.VWmemPosDAO;
import com.ddit.dto.VWmemPosVO;
import com.ddit.ibatis.VWmemPos_iBatis;

public class VWmemPosServiceImpl implements VWmemposService{

	
	VWmemPos_iBatis  vWmemPos_iBatis;

	public void setVWmemPos(VWmemPos_iBatis vWmemPos_iBatis) {
		this.vWmemPos_iBatis = vWmemPos_iBatis;
	}



	@Override
	public VWmemPosVO memposVO(String id) throws SQLException {
		VWmemPosVO memposVO =  vWmemPos_iBatis.memposVO(id);
		System.out.println("()()SERVICE()()");
		return memposVO;
	}

}
