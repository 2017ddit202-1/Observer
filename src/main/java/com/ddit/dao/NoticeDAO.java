package com.ddit.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.NoticeVO;

public interface NoticeDAO {

	public void insertNotice(NoticeVO noticeVO) throws SQLException;
	public void updateNotice(NoticeVO noticeVO) throws SQLException;
	public int deleteNotice(int notice_seq) throws SQLException;
	NoticeVO selectNotice(int notice_seq) throws SQLException;
	public ArrayList<NoticeVO> listAllArticle() throws SQLException;
}
