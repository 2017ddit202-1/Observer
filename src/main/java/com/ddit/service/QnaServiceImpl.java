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
	public int updateQnaVO(QnaVO qnaVO) throws SQLException {
		qnaDAO.updateQnaVO(qnaVO);
		return 0;
	}

	
	

	
	@Override
	public QnaVO selectQna(int qseq, String userid) throws SQLException {
		QnaVO qnaVO = new QnaVO();
		 qnaVO = qnaDAO.selectQna(qseq, userid);
		return qnaVO;
	}

	
	
	
	
	@Override
	public int deleteQna(int qseq) throws SQLException {
		int result = -1;
		result = qnaDAO.deleteQna(qseq);
		return result;
	}

	
	
	
	@Override
	public int updateQnaCheck(QnaVO qnaVO) throws SQLException {
		int result = -1;
		
		result =  qnaDAO.updateQnaCheck(qnaVO);
		return result;
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
