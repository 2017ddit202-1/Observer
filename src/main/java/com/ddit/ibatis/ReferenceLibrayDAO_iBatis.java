package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.ReferenceLibrayDAO;
import com.ddit.dto.ReferenceLibrayVO;
import com.ddit.dto.VWmemPosVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class ReferenceLibrayDAO_iBatis implements ReferenceLibrayDAO{
	
	private SqlMapClient client;
	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	
	static int view_rows = 10; // 
	static int counts = 10; //
	
	@Override
	public int insertReference(ReferenceLibrayVO referenceVO) throws SQLException {
		System.out.println("ReferenceLibrayDAO_iBatis"+referenceVO);
		int result = -1;
		if(client.insert("insertReference",referenceVO) != null){
			result=-1;
		}else{
			result=1;
		}
		return result;
	
	}

	@Override
	public void updateRef(ReferenceLibrayVO RefVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteRef(int reli_seq) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ReferenceLibrayVO selectRef(int reli_seq) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<ReferenceLibrayVO> listAllReference() throws SQLException {
		ArrayList<ReferenceLibrayVO> referenceList = (ArrayList<ReferenceLibrayVO>)client.queryForList("listReference");
		return referenceList;
	}


	@Override
	public ReferenceLibrayVO detailReference(int reli_seq) throws SQLException {
		ReferenceLibrayVO referenceVO = new ReferenceLibrayVO();
		referenceVO=(ReferenceLibrayVO)client.queryForObject("detailReference",reli_seq);
		return referenceVO;
	}

	@Override
	public void updateReference(ReferenceLibrayVO referenceVO) throws SQLException {
		client.update("updateReference",referenceVO);
	}

	@Override
	public void updateReferenceFileUp(ReferenceLibrayVO referenceVO)
			throws SQLException {
		client.update("updateReferenceFileUp",referenceVO);
		
	}

	@Override
	public void deleteReference(int reli_seq) throws SQLException {
		client.delete("deleteReference",reli_seq);
		
	}

	@Override
	public ArrayList<ReferenceLibrayVO> ReferenceList(String reli_seq, int tpage)
			throws SQLException {
		int startRow = -1;
		int endRow = -1;

		if (reli_seq == "") {
			reli_seq = "%";
		}
		
		int totalRecord = rfPagingCon(reli_seq);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;
		ArrayList<ReferenceLibrayVO> VWmemList = (ArrayList<ReferenceLibrayVO>) client.queryForList("ReferenceList",reli_seq,startRow,counts);
		return VWmemList;
	}

	@Override
	public String totalReferenceList(String reli_seq, int tpage)
			throws SQLException {
		String str = "";

		int total_pages = rfPagingCon(reli_seq);
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
			str += "<a href='rfList?tpage=1&key=" + reli_seq
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='rfList?tpage=" + (start_page - 1);
			str += "&key=<%=fb_id%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='rfList?tpage=" + i + "&key="
						+ reli_seq + "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='rfList?tpage=" + (end_page + 1)
					+ "&key=" + reli_seq + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='rfList?tpage=" + page_count
					+ "&key=" + reli_seq + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}
	
	public int rfPagingCon(String reli_seq) throws SQLException{
		int total_pages = 0;
		if (reli_seq.equals("")) {
			reli_seq = "%";
		}
		total_pages = (Integer) client.queryForObject("totalReferenceList",
				reli_seq);
		return total_pages-1;
	}

	@Override
	public int totalReference() throws SQLException {
		return (int) client.queryForObject("totalReference");
	}


	



}
