package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.FreeBoardDAO;
import com.ddit.dto.FreeBoardVO;
import com.ddit.dto.Notice_ArticleVO;
import com.ddit.dto.QnaVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class FreeBoardDAO_iBatis implements FreeBoardDAO{
	
	private SqlMapClient client;
	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public int insertFB(FreeBoardVO freeBoardVO) throws SQLException {
		int result = -1;
		if(client.insert("insertFb",freeBoardVO) != null){
			result=-1;
		}else{
			result=1;
		}
		return result;
	}

	@Override
	public void updateFB(FreeBoardVO freeBoardVO) throws SQLException {
		client.update("updateFb",freeBoardVO);
	}

	@Override
	public int deleteFB(int fb_seq) throws SQLException {
		return client.delete("deleteFb",fb_seq);
	}

	@Override
	public FreeBoardVO selectFB(int fb_seq) throws SQLException {
		FreeBoardVO fbVO = (FreeBoardVO) client.queryForObject("selectFb",fb_seq);
		
		return fbVO;
	}

	@Override
	public ArrayList<FreeBoardVO> listAllFb() throws SQLException {
		ArrayList<FreeBoardVO> fbList = (ArrayList<FreeBoardVO>) client.queryForList("listFb");
		return fbList;
	}

	@Override
	public FreeBoardVO fbDetail(int fb_seq) throws SQLException {
		FreeBoardVO fbVO = (FreeBoardVO) client.queryForObject("detailFb",fb_seq);
		return fbVO;
	}
	
	
	
	
	public int fbPaging(String fb_id) throws SQLException{
		int total_pages = 0;
		if (fb_id.equals("")) {
			fb_id = "%";
		}
		total_pages = (Integer) client.queryForObject("totalFb",
				fb_id);
		return total_pages;
	}

	static int view_rows = 10; // 
	static int counts = 10; //

	@Override
	public String pageNumber(int tpage, String fb_id) throws SQLException {
		String str = "";

		int total_pages = fbPaging(fb_id);
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
			str += "<a href='fbList?tpage=1&key=" + fb_id
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='fbList.did?tpage=" + (start_page - 1);
			str += "&key=<%=fb_id%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='fbList?tpage=" + i + "&key="
						+ fb_id + "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='fbList?tpage=" + (end_page + 1)
					+ "&key=" + fb_id + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='fbList?tpage=" + page_count
					+ "&key=" + fb_id + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}

	@Override
	public ArrayList<FreeBoardVO> listFbPage(int tpage, String fb_id)
			throws SQLException {
		int startRow = -1;
		int endRow = -1;

		if (fb_id == "") {
			fb_id = "%";
		}
		
		int totalRecord = fbPaging(fb_id);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;
		ArrayList<FreeBoardVO> fblist = (ArrayList<FreeBoardVO>) client
				.queryForList("listFbPage", fb_id, startRow,counts);
		return fblist;
	}

	@Override
	public int fb_cnt(int fb_seq) throws SQLException {
		return client.update("readCount",fb_seq);
	}

}
