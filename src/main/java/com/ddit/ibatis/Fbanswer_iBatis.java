package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ddit.dao.FbanswerDAO;
import com.ddit.dto.FbanswerVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class Fbanswer_iBatis implements FbanswerDAO{
	
	private SqlMapClient client;
	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public int insertFbanswer(FbanswerVO fbanswerVO) throws SQLException {
		int result = -1;
		if(client.insert("insertFbAns", fbanswerVO) != null){
			result = -1;
		}else{
			result = 1;
		}
		return result;
	}

	@Override
	public void updateFbanswer(FbanswerVO fbanswerVO) throws SQLException {
		client.update("updateFbAns", fbanswerVO);
	}

	@Override
	public int deleteFbanswer(int fbans_seq) throws SQLException {
		int result = client.delete("deleteFbAns",fbans_seq);
		return result;
	}

	@Override
	public FbanswerVO selectFbanswer(int fbans_seq) throws SQLException {
//		return (FbanswerVO) client.queryForObject("selectFbAns",fbans_seq);
		return null;
	}

	@Override
	public List<FbanswerVO> listAllFbAnswer(int fbans_seq) throws SQLException {
		List<FbanswerVO> list = client.queryForList("selectFbAns",fbans_seq);
		return list;
	}


}
