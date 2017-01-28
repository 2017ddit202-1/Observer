package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.FreeBoardVO;

public interface FreeBoardService {

	public int insertFb(FreeBoardVO freeBoardVO) throws SQLException;
	public void updateFb(FreeBoardVO freeBoardVO) throws SQLException;
	public int deleteFb(int fb_seq) throws SQLException;
	FreeBoardVO selectFb(int fb_seq) throws SQLException;
	public ArrayList<FreeBoardVO> listAllFb() throws SQLException;
}
