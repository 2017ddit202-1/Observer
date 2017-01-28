package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.FreeBoardDAO;
import com.ddit.dto.FreeBoardVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class FreeBoardDAO_iBatis implements FreeBoardDAO{
	
	private SqlMapClient client;
	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public int insertFB(FreeBoardVO freeBoardVO) throws SQLException {
		int result = -1;
		if(client.insert("insertFb",freeBoardVO) != null){
			result=-1;
		}else{
			result=1;
		}
		return result;
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
	public ArrayList<FreeBoardVO> listAllFb() throws SQLException {
		ArrayList<FreeBoardVO> fbList = (ArrayList<FreeBoardVO>) client.queryForList("listFb");
		return fbList;
	}

}
