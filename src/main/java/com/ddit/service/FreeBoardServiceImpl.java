package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.FreeBoardVO;
import com.ddit.ibatis.FreeBoardDAO_iBatis;

public class FreeBoardServiceImpl implements FreeBoardService{
	
	private FreeBoardDAO_iBatis freeBoardDAO_iBatis;
	public void setFreeBoardDAO_iBatis(FreeBoardDAO_iBatis freeBoardDAO_iBatis){
		this.freeBoardDAO_iBatis = freeBoardDAO_iBatis;
	}

	@Override
	public int insertFb(FreeBoardVO freeBoardVO) throws SQLException {
		int result = freeBoardDAO_iBatis.insertFB(freeBoardVO);
		return result;
	}

	@Override
	public void updateFb(FreeBoardVO freeBoardVO) throws SQLException {
		freeBoardDAO_iBatis.updateFB(freeBoardVO);
	}

	@Override
	public int deleteFb(int fb_seq) throws SQLException {
		return freeBoardDAO_iBatis.deleteFB(fb_seq);
	}

	@Override
	public FreeBoardVO selectFb(int fb_seq) throws SQLException {
		return freeBoardDAO_iBatis.selectFB(fb_seq);
	}

	@Override
	public ArrayList<FreeBoardVO> listAllFb() throws SQLException {
		ArrayList<FreeBoardVO> fbList = null;
		fbList = freeBoardDAO_iBatis.listAllFb();
		return fbList;
	}

	@Override
	public FreeBoardVO fbDetail(int fb_seq) throws SQLException {
		return freeBoardDAO_iBatis.fbDetail(fb_seq);
	}

	@Override
	public String pageNumber(int tpage, String fb_id) throws SQLException {
		String str = freeBoardDAO_iBatis.pageNumber(tpage, fb_id);
		return str;
	}

	@Override
	public ArrayList<FreeBoardVO> listFbPage(int tpage, String fb_id)
			throws SQLException {
		ArrayList<FreeBoardVO> fbList = freeBoardDAO_iBatis.listFbPage(tpage, fb_id);
		return fbList;
	}

	@Override
	public int fb_cnt(int fb_seq) throws SQLException {
		return freeBoardDAO_iBatis.fb_cnt(fb_seq);
	}

}
