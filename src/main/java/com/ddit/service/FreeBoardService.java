package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.FreeBoardVO;
import com.ddit.dto.QnaVO;

public interface FreeBoardService {

	public int insertFb(FreeBoardVO freeBoardVO) throws SQLException;
	public void updateFb(FreeBoardVO freeBoardVO) throws SQLException;
	public int deleteFb(int fb_seq) throws SQLException;
	FreeBoardVO selectFb(int fb_seq) throws SQLException;
	public ArrayList<FreeBoardVO> listAllFb() throws SQLException;
	
	public FreeBoardVO fbDetail(int fb_seq) throws SQLException;
	public String pageNumber(int tpage, String fb_id) throws SQLException;
	public ArrayList<FreeBoardVO> listFbPage(int tpage,String fb_id) throws SQLException;
	
	public int fb_cnt(int fb_seq) throws SQLException;
	
	public ArrayList<FreeBoardVO> searchSub(String fb_sub,int tpage) throws SQLException;
	public String pageNumberSub(int tpage, String fb_sub) throws SQLException;
	public ArrayList<FreeBoardVO> searchCon(String fb_con,int tpage) throws SQLException;
	public String pageNumberCon(int tpage, String fb_con) throws SQLException;
	public ArrayList<FreeBoardVO> searchId(String userId,int tpage) throws SQLException;
	
}
