package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.FreeBoardVO;

public interface FreeBoardService {

	public int insertCpu(FreeBoardVO freeBoardVO) throws SQLException;
	public void updateCpu(FreeBoardVO freeBoardVO) throws SQLException;
	public int deleteCpu(int fb_seq) throws SQLException;
	FreeBoardVO selectCpu(int fb_seq) throws SQLException;
	public ArrayList<FreeBoardVO> listAllArticle() throws SQLException;
}
