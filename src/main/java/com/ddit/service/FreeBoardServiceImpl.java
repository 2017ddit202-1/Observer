package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.FreeBoardVO;
import com.ddit.ibatis.FreeBoardDAO_iBatis;

public class FreeBoardServiceImpl implements FreeBoardService{
	
	private FreeBoardDAO_iBatis freeBoardDAO_iBatis;
	public void setFreeBoardDAO_iBatis(FreeBoardDAO_iBatis freeBoardDAO_iBatis){
		this.freeBoardDAO_iBatis = freeBoardDAO_iBatis;
	}

	@Override
	public int insertFb(FreeBoardVO freeBoardVO) throws SQLException {
		int result = freeBoardDAO_iBatis.insertFB(freeBoardVO);
		return result;
	}

	@Override
	public void updateFb(FreeBoardVO freeBoardVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteFb(int fb_seq) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FreeBoardVO selectFb(int fb_seq) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<FreeBoardVO> listAllFb() throws SQLException {
		ArrayList<FreeBoardVO> fbList = null;
		fbList = freeBoardDAO_iBatis.listAllFb();
		return fbList;
	}

}
