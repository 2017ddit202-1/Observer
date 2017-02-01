package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.QanswerDAO;
import com.ddit.dto.QanswerVO;

public class QanswerServiceImpl implements QanswerService{

	QanswerDAO qanswerDAO;
	public void setQanswerDAO(QanswerDAO qanswerDAO) {
		this.qanswerDAO = qanswerDAO;
	}

	@Override
	public int insertQanswer(QanswerVO QanswerVO) throws SQLException {

		qanswerDAO.insertQanswer(QanswerVO);
		
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
	public QanswerVO selectQanswer(int qans_qseq) throws SQLException {
		QanswerVO qnasVO = (QanswerVO)qanswerDAO.selectQansVO(qans_qseq);
		return qnasVO;
	}

	@Override
	public ArrayList<QanswerVO> listAllArticle() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
