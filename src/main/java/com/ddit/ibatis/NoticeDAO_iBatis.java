package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.NoticeDAO;
import com.ddit.dao.Notice_ArticleDAO;
import com.ddit.dto.NoticeVO;

public class NoticeDAO_iBatis implements NoticeDAO{

	@Override
	public int insertNotice(NoticeVO noticeVO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateNotice(NoticeVO noticeVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteNotice(int notice_seq) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NoticeVO selectNotice(int notice_seq) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NoticeVO> listAllArticle() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
