package com.ddit.ibatis;

import java.sql.SQLException;

import com.ddit.dao.QnaDAO;
import com.ddit.dto.QnaVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class QnaDAO_iBatis implements QnaDAO {

	private SqlMapClient client;
	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	
	
	@Override
	public QnaVO getQna(int qseq) throws SQLException {
		QnaVO qnaVO = (QnaVO)client.queryForObject("getQna", qseq);
		return qnaVO;
	}

}
