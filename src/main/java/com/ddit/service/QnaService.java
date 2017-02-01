package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.QnaVO;


public interface QnaService {
	/*public QnaVO getQna(int qseq) throws SQLException;*/
	public QnaVO getQna(int qseq) throws SQLException; 
	
	/*public ArrayList<QnaVO> listAllQna() throws SQLException;*/
	public ArrayList<QnaVO> listAllQna() throws SQLException;
	
	public void insertQna(QnaVO qnaVO) throws SQLException;
	
	public String totalPage(int tpage, String qna_id) throws SQLException;
	
	public ArrayList<QnaVO> listqnalist(int tpage,String qna_id) throws SQLException;
	public int updateQnaCheck(QnaVO qnaVO) throws SQLException;
	public int deleteQna(int qseq) throws SQLException;
	
	public QnaVO selectQna(int qseq, String userid)throws SQLException;
	
	public int updateQnaVO(QnaVO qnaVO) throws SQLException;
	
	
}
