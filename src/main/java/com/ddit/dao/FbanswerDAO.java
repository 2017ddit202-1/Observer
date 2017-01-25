package com.ddit.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.FbanswerVO;

public interface FbanswerDAO {
	
	public int insertFbanswer(FbanswerVO FbanswerVO) throws SQLException;
	public void updateFbanswer(FbanswerVO FbanswerVO) throws SQLException;
	public int deleteFbanswer(int fbans_seq) throws SQLException;
	FbanswerVO selectFbanswer(int fbans_seq) throws SQLException;
	public ArrayList<FbanswerVO> listAllArticle() throws SQLException;
}