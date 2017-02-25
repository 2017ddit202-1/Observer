package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.SuperAdminDAO;
import com.ddit.dto.FreeBoardVO;
import com.ddit.dto.MemberVO;
import com.ddit.dto.VWmemPosVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class SuperAdminDAO_iBatis implements SuperAdminDAO {
	
	private SqlMapClient client;
	 public void setClient(SqlMapClient client){
		 this.client=client;
	 }
	
	static int view_rows = 10; // 
	static int counts = 10; //
	 
	@Override
	public void authorityUpdateMember(MemberVO memberVO) throws SQLException {
		client.update("authorityUpdateMember", memberVO);
	}

	@Override
	public ArrayList<VWmemPosVO> VWmemPosMemberAll() throws SQLException {
		return (ArrayList<VWmemPosVO>) client.queryForList("VWmemPosMemberAll");
	}

	@Override
	public ArrayList<VWmemPosVO> VWmemSerchId(String mem_id, int tpage)
			throws SQLException {
		int startRow = -1;
		int endRow = -1;

		if (mem_id == "") {
			mem_id = "%";
		}
		
		int totalRecord = fbPagingCon(mem_id);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;
		ArrayList<VWmemPosVO> VWmemList = (ArrayList<VWmemPosVO>) client.queryForList("VWmemSerchId",mem_id,startRow,counts);
		return VWmemList;
	}

	@Override
	public String pageNumberId(int tpage, String mem_id) throws SQLException {
		String str = "";

		int total_pages = fbPagingCon(mem_id);
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
			str += "<a href='authorityMemberList?tpage=1&key=" + mem_id
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='authorityMemberList?tpage=" + (start_page - 1);
			str += "&key=<%=fb_id%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='authorityMemberList?tpage=" + i + "&key="
						+ mem_id + "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='authorityMemberList?tpage=" + (end_page + 1)
					+ "&key=" + mem_id + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='authorityMemberList?tpage=" + page_count
					+ "&key=" + mem_id + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}
	
	public int fbPagingCon(String mem_id) throws SQLException{
		int total_pages = 0;
		if (mem_id.equals("")) {
			mem_id = "%";
		}
		total_pages = (Integer) client.queryForObject("totalVWmemSerchId",
				mem_id);
		return total_pages-1;
	}

}
