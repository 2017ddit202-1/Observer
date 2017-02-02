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
		client.update("updateFb",freeBoardVO);
	}

	@Override
	public int deleteFB(int fb_seq) throws SQLException {
		return client.delete("deleteFb",fb_seq);
	}

	@Override
	public FreeBoardVO selectFB(int fb_seq) throws SQLException {
		FreeBoardVO fbVO = (FreeBoardVO) client.queryForObject("selectFb",fb_seq);
		
		return fbVO;
	}

	@Override
	public ArrayList<FreeBoardVO> listAllFb() throws SQLException {
		ArrayList<FreeBoardVO> fbList = (ArrayList<FreeBoardVO>) client.queryForList("listFb");
		return fbList;
	}

	@Override
	public FreeBoardVO fbDetail(int fb_seq) throws SQLException {
		FreeBoardVO fbVO = (FreeBoardVO) client.queryForObject("detailFb",fb_seq);
		return fbVO;
	}

}
