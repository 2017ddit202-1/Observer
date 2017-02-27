package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.AdminDAO;
import com.ddit.dto.AdminVO;
import com.ddit.dto.Notice_ArticleVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class AdminDAO_iBatis implements AdminDAO {

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public ArrayList<AdminVO> listAllAdmin() throws SQLException {
		return (ArrayList<AdminVO>) client.queryForList("listAllAdmin");
	}

	@Override
	public void insertAdmin(AdminVO adminVO) throws SQLException {
		client.insert("insertAdmin", adminVO);

	}

	@Override
	public void deleteAdmin(int admin_seq) throws SQLException {
		client.delete("deleteAdmin", admin_seq);

	}

	@Override
	public AdminVO select_Seq(int admin_seq) throws SQLException {
		return (AdminVO) client.queryForObject("select_Seq", admin_seq);
	}

	@Override
	public void updateAdmin(AdminVO adminVO) throws SQLException {
		client.update("updateAdmin", adminVO);

	}

	@Override
	public void nswerAdmin(AdminVO adminVO) throws SQLException {
		client.update("nswerAdmin", adminVO);

	}

	@Override
	public ArrayList<AdminVO> nswerN() throws SQLException {
		return (ArrayList<AdminVO>) client.queryForList("nswerN");
	}

	@Override
	public ArrayList<AdminVO> nswerY() throws SQLException {
		return (ArrayList<AdminVO>) client.queryForList("nswerY");
	}

	@Override
	public ArrayList<AdminVO> Search_ad_seq(int keyword) throws SQLException {
		return (ArrayList<AdminVO>) client.queryForList("Search_ad_seq",
				keyword);
	}

	@Override
	public ArrayList<AdminVO> Search_ad_id(String keyword) throws SQLException {
		return (ArrayList<AdminVO>) client
				.queryForList("Search_ad_id", keyword);
	}

	@Override
	public ArrayList<AdminVO> Search_ad_subject(String keyword)
			throws SQLException {
		return (ArrayList<AdminVO>) client.queryForList("Search_ad_subject",
				keyword);
	}
	
	
	
	//페이징 하기위한 메서드
		public int totalArticle(String ad_id)throws SQLException{//게시글의모든 갯수를 가져오는 메소드
			int total_page = 0;
			if(ad_id.equals("")){ //아이디가 없으면
				ad_id ="%";
			}
			total_page = (Integer)client.queryForObject("totalAdmin",ad_id);//공지사항의 모든 행을 가지고옴
			return total_page; //행의갯수 리턴
		}
		static int view_rows=10;///////////페이징숫자
		static int counts=10;//한페이지 게시글 갯수
	
	

	@Override
	public ArrayList<AdminVO> listAdminlist(int tpage, String ad_id)
			throws SQLException {
		int startRow = -1;
		int endRow = -1;

		if (ad_id == "") {
			ad_id = "%";
		}
		
		int totalRecord = totalArticle(ad_id);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;
		ArrayList<AdminVO> adminList = (ArrayList<AdminVO>) client
				.queryForList("listAdminlist", ad_id, startRow,counts);
		return adminList;
	}

	@Override
	public String totalAdmin(int tpage, String ad_id) throws SQLException {
		String str="";
		
		
		int total_pages = totalArticle(ad_id); 
		int page_count = total_pages / counts + 1; //전체게시글/한페이지게시글 갯수+1
		
		//전제게시글에서 10을 나눈 나머지가 0이면
	    if(total_pages % counts ==0){///////////////////////
	    	page_count--;
	    }
	    if(tpage < 1){
	    	tpage =1;
	    }
	    
	    int start_page = tpage - (tpage % view_rows) + 1;
	    int end_page = start_page + (counts -1);
	    
	    if (end_page > page_count) {
			end_page = page_count;
		}
		if (start_page > view_rows) {
			str += "<a href='adminQnaList?tpage=1&key=" + ad_id
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='adminQnaList.did?tpage=" + (start_page - 1);
			str += "&key=<%=noar_id%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='adminQnaList?tpage=" + i + "&key="
						+ ad_id + "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='articleView?tpage=" + (end_page + 1)
					+ "&key=" + ad_id + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='articleView?tpage=" + page_count
					+ "&key=" + ad_id + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		
	
		return str;
	}

	

}
