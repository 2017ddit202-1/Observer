package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.MemberDAO;
import com.ddit.dto.MemberVO;
import com.ddit.dto.PositionListVO;
import com.ddit.dto.VWmemPosVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class MemberDAO_iBatis implements MemberDAO{
	
	 private SqlMapClient client;
	 public void setClient(SqlMapClient client){
		 this.client=client;
	 }

	static int view_rows = 10; // 
	static int counts = 10; //
	
	@Override
	public int insertMember(MemberVO memberVO) throws SQLException {
		
		int result=-1;//실패
		if(client.insert("insertMember", memberVO) != null){
			result=-1;
		}else{
			result=1; //성공
		}
		return result;
	}

	@Override
	public void updateMember(MemberVO memberVO) throws SQLException {
		client.update("updateMember", memberVO);
		
	}

	@Override
	public int deleteMember(String userid) throws SQLException {
		int result=client.delete("deleteMember", userid);
		return result;
	}


	@Override
	public int confirmID(String userid) throws SQLException {
		int result=-1;//실패
		if(client.queryForObject("confirmID",userid) != null){
			result=-1;
		}else{
			result=1; //성공
		}
		return result;
	}


	@Override
	public MemberVO selectMember(String userid) throws SQLException {
		MemberVO memberVO = (MemberVO) client.queryForObject("selectMember", userid);
		
		return memberVO;
	}


	@Override
	public void deleteuseMember(MemberVO memberVO) throws SQLException {
		client.update("deleteuseMember", memberVO.getMem_pwd());
		
	}


	@Override
	public void positionRole(String userid) throws SQLException {
		client.insert("positionRole",userid);
		
	}


	@Override
	public MemberVO idFind(String name, String email) throws SQLException {
		MemberVO idFind = new MemberVO();
		idFind.setMem_nm(name);
		idFind.setMem_email(email);
		
		MemberVO member = (MemberVO) client.queryForObject("idFind",idFind);
		
		return member;
	}


	@Override
	public MemberVO pwdFind(String userid, String email) throws SQLException {
		MemberVO pwdFind = new MemberVO();
		pwdFind.setMem_id(userid);
		pwdFind.setMem_email(email);
		
		MemberVO member = (MemberVO) client.queryForObject("pwdFind",pwdFind);
		
		return member;
	}


	@Override
	public void tempPwd(MemberVO memberVO) throws SQLException {
		client.update("pwdUpdate",memberVO);
		
	}


	@Override
	public MemberVO confirmID2(String userid) throws SQLException {
		return (MemberVO) client.queryForObject("confirmID",userid);
		
	}


	@Override
	public void memberEnabled(String userid) throws SQLException {
	  client.update("memberEnabled", userid);
		
	}


	@Override
	public PositionListVO authoritySelect(String userid) throws SQLException {
		return (PositionListVO) client.queryForObject("authoritySelect",userid);
		
	}


	@Override
	public ArrayList<MemberVO> selectMemberAll() throws SQLException {
		return (ArrayList<MemberVO>) client.queryForList("selectMemberAll");
	}


	@Override
	public ArrayList<MemberVO> groupmember(String lice) throws SQLException {	
		return (ArrayList<MemberVO>) client.queryForList("groupmember",lice);
	}


	@Override
	public void updateLice(MemberVO memberVO) throws SQLException {
		client.update("updateLice", memberVO);
		
	}


	@Override
	public void updatePositionList(PositionListVO positionListVO)
			throws SQLException {
		client.update("updatePositionList",positionListVO);
	}


	@Override
	public int memberCnt() throws SQLException {
		return (int) client.queryForObject("memberCnt");
	}


	@Override
	public int enabledCnt() throws SQLException {
		return (int) client.queryForObject("enabledCnt");
	}


	@Override
	public int userCnt() throws SQLException {
		return (int) client.queryForObject("userCnt");
	}


	@Override
	public int adminCnt() throws SQLException {
		return (int) client.queryForObject("adminCnt");
	}


	@Override
	public int authorityCnt() throws SQLException {
		return (int) client.queryForObject("authorityCnt");
	}


	@Override

	public int joinKeyUp(String mem_id) throws SQLException {
		int result= -1;
		MemberVO memberVO= (MemberVO) client.queryForObject("confirmID",mem_id);
		if(memberVO != null){
			result = 1;
		}else{
			result = -1;
		}
		return result;
	}


	public ArrayList<MemberVO> groupmember(int tpage, String lice)
			throws SQLException {
		int startRow = -1;
		int endRow = -1;
		
		int totalRecord = gpPagingCon(lice);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;
		ArrayList<MemberVO> memList = (ArrayList<MemberVO>) client.queryForList("groupmember",lice,startRow,counts);
		return memList;
	}

	public int gpPagingCon(String mem_id) throws SQLException{
		int total_pages = 0;
		
		total_pages = (Integer) client.queryForObject("totalgroupmember",
				mem_id);
		return total_pages;
	}

	@Override
	public String pageNumberlice(int tpage, String lice) throws SQLException {
		String str = "";

		int total_pages = gpPagingCon(lice);
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
			str += "<a href='meminvalid?tpage=1&key=" + lice
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='meminvalid?tpage=" + (start_page - 1);
			str += "&key=<%=fb_id%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='meminvalid?tpage=" + i + "&key="
						+ lice + "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='meminvalid?tpage=" + (end_page + 1)
					+ "&key=" + lice + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='meminvalid?tpage=" + page_count
					+ "&key=" + lice + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}

	@Override
	public ArrayList<MemberVO> groupmemberlist(int tpage, MemberVO lice)
			throws SQLException {
		int startRow = -1;
		int endRow = -1;
		
		int totalRecord = gpListPagingCon(lice);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;
		ArrayList<MemberVO> memList = (ArrayList<MemberVO>) client.queryForList("groupmemberlist",lice,startRow,counts);
		return memList;
	}

	@Override
	public String pageNumbergrlice(int tpage, MemberVO lice) throws SQLException {
		String str = "";

		int total_pages = gpListPagingCon(lice);
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
			str += "<a href='groupList?tpage=1&key=" + lice
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='groupList?tpage=" + (start_page - 1);
			str += "&key=<%=fb_id%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='groupList?tpage=" + i + "&key="
						+ lice + "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='groupList?tpage=" + (end_page + 1)
					+ "&key=" + lice + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='groupList?tpage=" + page_count
					+ "&key=" + lice + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}
	
	public int gpListPagingCon(MemberVO mem_id) throws SQLException{
		int total_pages = 0;
		
		total_pages = (Integer) client.queryForObject("totalgroupmemberlist",
				mem_id);
		return total_pages;
	}

	

}
