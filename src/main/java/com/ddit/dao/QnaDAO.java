package com.ddit.dao;

import java.sql.SQLException;

import com.ddit.dto.QnaVO;

public interface QnaDAO {
	public QnaVO getQna(int qseq) throws SQLException;
	
}
