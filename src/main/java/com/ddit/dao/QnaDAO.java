package com.ddit.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.QnaVO;

public interface QnaDAO {
	public ArrayList<QnaVO> listAllQna() throws SQLException;
	public QnaVO getQna(int qseq) throws SQLException;
	public void insertqna(QnaVO qnaVO) throws SQLException;
	public String pageNumber(int tpage, String qna_id) throws SQLException;
	public ArrayList<QnaVO> listqnalist(int tpage,String qna_id) throws SQLException;

	
}
