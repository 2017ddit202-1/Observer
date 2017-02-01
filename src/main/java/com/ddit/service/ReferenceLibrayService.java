package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.ReferenceLibrayVO;

public interface ReferenceLibrayService {

	public int insertReference(ReferenceLibrayVO referenceVO) throws SQLException;
	public void updateRef(ReferenceLibrayVO RefVO) throws SQLException;
	public int deleteRef(int reli_seq) throws SQLException;
	ReferenceLibrayVO selectRef(int reli_seq) throws SQLException;
	public ArrayList<ReferenceLibrayVO> listAllReference()throws SQLException;
	
}
