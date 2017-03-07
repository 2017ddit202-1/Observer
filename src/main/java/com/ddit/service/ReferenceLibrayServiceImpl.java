package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.ReferenceLibrayDAO;
import com.ddit.dto.ReferenceLibrayVO;
import com.ddit.dto.VWmemPosVO;

public class ReferenceLibrayServiceImpl implements ReferenceLibrayService{

	ReferenceLibrayDAO referenceDAO;
	public void setReferenceDAO(ReferenceLibrayDAO referenceDAO) {
		this.referenceDAO = referenceDAO;
	}

	@Override
	public int insertReference(ReferenceLibrayVO referenceVO) throws SQLException{
		referenceDAO.insertReference(referenceVO);
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

	@Override
	public ReferenceLibrayVO detailReference(int reli_seq) throws SQLException {
		ReferenceLibrayVO referenceVO = new ReferenceLibrayVO();
		referenceVO=referenceDAO.detailReference(reli_seq);
		return referenceVO;
	}

	@Override
	public void updateReference(ReferenceLibrayVO referenceVO)throws SQLException{
		referenceDAO.updateReference(referenceVO);
		
	}

	@Override
	public void updateReferenceFileUp(ReferenceLibrayVO referenceVO)
			throws SQLException {
		referenceDAO.updateReferenceFileUp(referenceVO);
		
	}

	@Override
	public void deleteReference(int reli_seq) throws SQLException {
		referenceDAO.deleteReference(reli_seq);
		
	}

	@Override
	public ArrayList<ReferenceLibrayVO> ReferenceList(String reli_seq, int tpage)
			throws SQLException {
		return referenceDAO.ReferenceList(reli_seq, tpage);
	}

	@Override
	public String totalReferenceList(String reli_seq, int tpage)
			throws SQLException {
		return referenceDAO.totalReferenceList(reli_seq, tpage);
	}

	@Override
	public int totalReference() throws SQLException {
		return referenceDAO.totalReference();
	}



	
}
