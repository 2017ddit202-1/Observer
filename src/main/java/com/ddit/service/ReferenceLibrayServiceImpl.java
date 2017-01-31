package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.ReferenceLibrayDAO;
import com.ddit.dto.ReferenceLibrayVO;

public class ReferenceLibrayServiceImpl implements ReferenceLibrayService{

	ReferenceLibrayDAO referenceDAO;
	public void setReferenceDAO(ReferenceLibrayDAO referenceDAO) {
		this.referenceDAO = referenceDAO;
	}

	@Override
	public int insertRef(ReferenceLibrayVO RefVO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateRef(ReferenceLibrayVO RefVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteRef(int reli_seq) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ReferenceLibrayVO selectRef(int reli_seq) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReferenceLibrayVO> listAllReference()throws SQLException{
		
		ArrayList<ReferenceLibrayVO> referenceVO = null;
		referenceVO=referenceDAO.listAllReference();
		return referenceVO;
	}



	
}
