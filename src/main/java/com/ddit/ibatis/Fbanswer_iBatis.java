package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteFbanswer(int fbans_seq) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FbanswerVO selectFbanswer(int fbans_seq) throws SQLException {
		return (FbanswerVO) client.queryForObject("selectFbAns", fbans_seq);
	}

	@Override
	public ArrayList<FbanswerVO> listAllArticle() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
