package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.FbanswerDAO;
import com.ddit.dto.FbanswerVO;

public class Fbanswer_iBatis implements FbanswerDAO{

	@Override
	public int insertFbanswer(FbanswerVO FbanswerVO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateFbanswer(FbanswerVO FbanswerVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteFbanswer(int fbans_seq) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FbanswerVO selectFbanswer(int fbans_seq) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<FbanswerVO> listAllArticle() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
