package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.QnaDAO;
import com.ddit.dto.QnaVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class QnaDAO_iBatis implements QnaDAO {



	

	private SqlMapClient client;
	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	
	
	@Override
	public int updateQnaCheck(QnaVO checkNum) throws SQLException {
		int result = -1;
		result = client.update("updateCheck",checkNum);
		System.out.println(result+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		return result;
	}
	
	
	@Override
	public ArrayList<QnaVO> listAllQna() throws SQLException {
		ArrayList<QnaVO> qnaList = new ArrayList<QnaVO>();
		qnaList = (ArrayList<QnaVO>) client.queryForList("listAllQna");
		return qnaList;
	}
	
	
	@Override
	public QnaVO getQna(int qseq) throws SQLException {
		QnaVO qnaVO = (QnaVO)client.queryForObject("getQna", qseq);
		return qnaVO;
	}

	
	@Override
	public void insertqna(QnaVO qnaVO) throws SQLException {
		client.insert("insertqna",qnaVO);
	}
	
	
	//페이징 하기위한 메서드

	public int totalQna(String qna_id) throws SQLException {
		int total_pages = 0;
		if (qna_id.equals("")) {
			qna_id = "%";
		}
		total_pages = (Integer) client.queryForObject("totalQna",
				qna_id);
		return total_pages;
	}

	static int view_rows = 10; // 
	static int counts = 10; //
	
	@Override
	public String pageNumber(int tpage, String qna_id) throws SQLException {
		String str = "";

		int total_pages = totalQna(qna_id);
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
			str += "<a href='qnaList?tpage=1&key=" + qna_id
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='qnaList.did?tpage=" + (start_page - 1);
			str += "&key=<%=qna_id%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='qnaList?tpage=" + i + "&key="
						+ qna_id + "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='qnaList?tpage=" + (end_page + 1)
					+ "&key=" + qna_id + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='qnaList?tpage=" + page_count
					+ "&key=" + qna_id + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}

	@Override
	public ArrayList<QnaVO> listqnalist(int tpage, String qna_id)
			throws SQLException {
		int startRow = -1;
		int endRow = -1;

		if (qna_id == "") {
			qna_id = "%";
		}
		
		int totalRecord = totalQna(qna_id);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;
		ArrayList<QnaVO> qnalist = (ArrayList<QnaVO>) client
				.queryForList("listQnalist", qna_id, startRow,counts);
		return qnalist;
	}
	
	
	
}
