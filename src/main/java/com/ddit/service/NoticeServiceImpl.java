package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.NoticeDAO;
import com.ddit.dto.NoticeVO;
import com.ddit.ibatis.AuthorityDAO_iBatis;
import com.ddit.ibatis.NoticeDAO_iBatis;

public class NoticeServiceImpl implements NoticeService {

	private NoticeDAO_iBatis noticeDAO;

	public void setNoticeDAO(NoticeDAO_iBatis noticeDAO) {
		this.noticeDAO = noticeDAO;
	}


	@Override
	public int insertCpu(NoticeVO noticeVO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateCpu(NoticeVO noticeVO) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int deleteCpu(int notice_seq) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NoticeVO selectCpu(int notice_seq) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NoticeVO> listAllArticle() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertNotice(NoticeVO noticeVO) throws SQLException {

		noticeDAO.insertNotice(noticeVO);
	}

}
