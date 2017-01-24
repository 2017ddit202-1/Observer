package com.ddit.service;

import java.sql.SQLException;

import com.ddit.dao.QnaDAO;
import com.ddit.dto.QnaVO;

public class QnaServiceImpl implements QnaService{

	QnaDAO qnaDAO;
	
	public void setQnaDAO(QnaDAO qnaDAO) {
		this.qnaDAO = qnaDAO;
	}




	@Override
	public QnaVO getQna(int qseq) throws SQLException {
		
		QnaVO qnaVO = null;
		qnaVO = qnaDAO.getQna(qseq);
		
		return qnaVO;
	}

}
