package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.FreeBoardDAO;
import com.ddit.dto.FreeBoardVO;

public class FreeBoardDAO_iBatis implements FreeBoardDAO{

	@Override
	public int insertFB(FreeBoardVO freeBoardVO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateFB(FreeBoardVO freeBoardVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteFB(int fb_seq) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FreeBoardVO selectFB(int fb_seq) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<FreeBoardVO> listAllArticle() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
