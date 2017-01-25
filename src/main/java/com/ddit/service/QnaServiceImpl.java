package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.QnaDAO;
import com.ddit.dto.QnaVO;

public class QnaServiceImpl implements QnaService {


	


	QnaDAO qnaDAO;

	public void setQnaDAO(QnaDAO qnaDAO) {
		this.qnaDAO = qnaDAO;
	}

	@Override
	public ArrayList<QnaVO> listAllQna() throws SQLException {
		ArrayList<QnaVO> qnaList = null;

		qnaList = qnaDAO.listAllQna();

		return qnaList;
	}

	@Override
	public QnaVO getQna(int qseq) throws SQLException {

		QnaVO qnaVO = null;
		qnaVO = qnaDAO.getQna(qseq);

		return qnaVO;
	}
	
	
	@Override
	public void insertQna(QnaVO qnaVO) throws SQLException {
		qnaDAO.insertqna(qnaVO);
		
	}
	
	
	@Override
	public String totalPage(int tpage, String qna_id) throws SQLException {
		
		String str = qnaDAO.pageNumber(tpage, qna_id);
		
		
		return str;
	}
	
	
	@Override
	public ArrayList<QnaVO> listqnalist(int tpage, String qna_id)
			throws SQLException {
		ArrayList<QnaVO> list = qnaDAO.listqnalist(tpage, qna_id);
		return list;
	}
	

}
