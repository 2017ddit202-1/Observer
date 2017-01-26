package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.QanswerDAO;
import com.ddit.dto.QanswerVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class QanswerDAO_iBatis implements QanswerDAO{

	private SqlMapClient client;
	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	
	
	@Override
	public int insertQanswer(QanswerVO QanswerVO) throws SQLException {
		client.insert("insertqans", QanswerVO);
		return 0;
	}

	@Override
	public void updateQanswer(QanswerVO QanswerVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteQanswer(int Qanswer_seq) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public QanswerVO selectQanswer(int Qanswer_seq) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<QanswerVO> listAllArticle() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
