package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.MemberGroupDAO;
import com.ddit.dto.MemberGroupVO;

public class MemberGroupDAO_iBatis implements MemberGroupDAO{

	@Override
	public int insertMemGroup(MemberGroupVO MemGroupVO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateMemGroup(MemberGroupVO MemGroupVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteMemGroup(String mg_lice) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberGroupVO selectMemGroup(String mg_lice) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MemberGroupVO> listAllArticle() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
