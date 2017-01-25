package com.ddit.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.FreeBoardVO;

public interface FreeBoardDAO {

	public int insertFB(FreeBoardVO freeBoardVO) throws SQLException;
	public void updateFB(FreeBoardVO freeBoardVO) throws SQLException;
	public int deleteFB(int fb_seq) throws SQLException;
	FreeBoardVO selectFB(int fb_seq) throws SQLException;
	public ArrayList<FreeBoardVO> listAllArticle() throws SQLException;
}
