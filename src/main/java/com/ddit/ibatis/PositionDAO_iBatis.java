package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.PositionListDAO;
import com.ddit.dto.PositionListVO;

public class PositionDAO_iBatis implements PositionListDAO{

	@Override
	public int insertPositionList(PositionListVO PositionListVO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updatePositionList(PositionListVO PositionListVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deletePositionList(String posl_id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PositionListVO selectPositionList(String posl_id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PositionListVO> listAllArticle() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
