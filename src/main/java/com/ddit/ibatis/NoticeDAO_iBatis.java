package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.NoticeDAO;
import com.ddit.dao.Notice_ArticleDAO;
import com.ddit.dto.MemberVO;
import com.ddit.dto.NoticeVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class NoticeDAO_iBatis implements NoticeDAO{
	
	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client = client; 
	}
	
	static int view_rows = 10; // 
	static int counts = 10; //

	@Override
	public void insertNotice(NoticeVO noticeVO) throws SQLException {
		// TODO Auto-generated method stub
		client.insert("insertNotice",noticeVO);
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
	public ArrayList<NoticeVO> listAllNotice(String lice) throws SQLException {
		ArrayList<NoticeVO> noticeList = (ArrayList<NoticeVO>) client.queryForList("listNotice", lice);
		return noticeList;
	}



	@Override
	public ArrayList<NoticeVO> Noticelist(int tpage, String lice)
			throws SQLException {
		int startRow = -1;
		int endRow = -1;
		
		int totalRecord = noticePagingCon(lice);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;
		ArrayList<NoticeVO> noticeList = (ArrayList<NoticeVO>) client.queryForList("Noticelist",lice,startRow,counts);
		return noticeList;
	}



	@Override
	public String totalNoticelist(int tpage, String lice) throws SQLException {
		String str = "";

		int total_pages = noticePagingCon(lice);
		int page_count = total_pages / counts + 1;

		if (total_pages % counts == 0) {
			page_count--;
		}
		if (tpage < 1) {
			tpage = 1;
		}

		int start_page = tpage - (tpage % view_rows) + 1;
		int end_page = start_page + (counts - 1);

		if (end_page > page_count) {
			end_page = page_count;
		}
		if (start_page > view_rows) {
			str += "<a href='noticeList?tpage=1&key=" + lice
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='noticeList?tpage=" + (start_page - 1);
			str += "&key=<%=fb_id%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='noticeList?tpage=" + i + "&key="
						+ lice + "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='noticeList?tpage=" + (end_page + 1)
					+ "&key=" + lice + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='noticeList?tpage=" + page_count
					+ "&key=" + lice + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}

	public int noticePagingCon(String mem_id) throws SQLException{
		int total_pages = 0;
		
		total_pages = (Integer) client.queryForObject("totalNoticelist",
				mem_id);
		return total_pages;
	}
}
