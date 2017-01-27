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
	
	//qans_qseq로 해당되는 QanswerVO 하나를 가져옴
	@Override
	public QanswerVO selectQansVO(int qans_qseq) throws SQLException {
		QanswerVO qnasVO =(QanswerVO) client.queryForObject("selectQansVO", qans_qseq); 
		return qnasVO;
	}
	
	//VO 객체를 넘겨 받아 DB에 작성된 답변을 insert함 
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
	public ArrayList<QanswerVO> listAllArticle() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
