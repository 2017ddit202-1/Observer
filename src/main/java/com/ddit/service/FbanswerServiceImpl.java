package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.FbanswerVO;
import com.ddit.ibatis.Fbanswer_iBatis;

public class FbanswerServiceImpl implements FbanswerService{
	
	private Fbanswer_iBatis fbAnswer_iBatis;
	public  void setFbAnswer_iBatis(Fbanswer_iBatis fbAnswer_iBatis){
		this.fbAnswer_iBatis = fbAnswer_iBatis;
	}
	@Override
	public int insertFbanswer(FbanswerVO fbanswerVO) throws SQLException {
		return fbAnswer_iBatis.insertFbanswer(fbanswerVO);
	}
	@Override
	public void updateFbanswer(FbanswerVO fbanswerVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int deleteFbanswer(int fbans_seq) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public FbanswerVO selectFbanswer(int fbans_seq) throws SQLException {
		return fbAnswer_iBatis.selectFbanswer(fbans_seq);
	}
	@Override
	public ArrayList<FbanswerVO> listAllArticle() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
