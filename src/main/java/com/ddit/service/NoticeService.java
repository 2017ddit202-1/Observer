package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.NoticeVO;
import com.ddit.dto.Notice_ArticleVO;

public interface NoticeService {

	public int insertCpu(NoticeVO noticeVO) throws SQLException;
	public void updateCpu(NoticeVO noticeVO) throws SQLException;
	public int deleteCpu(int notice_seq) throws SQLException;
	NoticeVO selectCpu(int notice_seq) throws SQLException;
	public ArrayList<NoticeVO> listAllArticle() throws SQLException;
	public void insertNotice(NoticeVO noticeVO) throws SQLException;
	
	public ArrayList<NoticeVO> listAllNotice(String lice) throws SQLException;
	public ArrayList<NoticeVO> Noticelist(int tpage, String lice) throws SQLException; 
	public String totalNoticelist(int tpage, String lice) throws SQLException;
}
