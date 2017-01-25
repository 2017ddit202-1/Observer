package com.ddit.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.QanswerVO;

public interface QanswerDAO {

	public int insertQanswer(QanswerVO QanswerVO) throws SQLException;
	public void updateQanswer(QanswerVO QanswerVO) throws SQLException;
	public int deleteQanswer(int Qanswer_seq) throws SQLException;
	QanswerVO selectQanswer(int Qanswer_seq) throws SQLException;
	public ArrayList<QanswerVO> listAllArticle() throws SQLException;
}