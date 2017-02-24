package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ddit.dao.Notice_ArticleDAO;
import com.ddit.dto.Notice_ArticleVO;
import com.ddit.dto.QnaVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class Notice_ArticleDAO_iBatis implements Notice_ArticleDAO{

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client = client; 
	}
	
	@Override
	public ArrayList<Notice_ArticleVO> listAllArticle() throws SQLException {
		ArrayList<Notice_ArticleVO> articleList = (ArrayList<Notice_ArticleVO>)client.queryForList("listArticle");
		return articleList;
	}

	@Override
	public int insertArticle(Notice_ArticleVO articleVO) throws SQLException {
		int result = -1;
		if(client.insert("insertArticle",articleVO) != null){
			result=-1;
		}else{
			result=1;
		}
		return result;
	}

	@Override
	public Notice_ArticleVO detailArticle(int noar_seq) throws SQLException {
		Notice_ArticleVO articleVO=(Notice_ArticleVO) client.queryForObject("detailArticle",noar_seq);
		return articleVO;
	}

	@Override
	public int deleteArticle(int noar_seq) throws SQLException {
		int result=client.delete("deleteArticle",noar_seq);
		return result;
	}

	@Override
	public void updateArticle(Notice_ArticleVO articleVO)
			throws SQLException {
		client.update("updateArticle", articleVO);
		
	}
	
	
	//페이징 하기위한 메서드
	public int totalArticle(String noar_id)throws SQLException{//게시글의모든 갯수를 가져오는 메소드
		int total_page = 0;
		if(noar_id.equals("")){ //아이디가 없으면
			noar_id ="%";
		}
		total_page = (Integer)client.queryForObject("totalArticle",noar_id);//공지사항의 모든 행을 가지고옴
		return total_page; //행의갯수 리턴
	}
	static int view_rows=10;///////////페이징숫자
	static int counts=10;//한페이지 게시글 갯수
	
	
	//페이징 하기위한 메서드 seq(int)
		public int totalArticle(int noar_id)throws SQLException{//게시글의모든 갯수를 가져오는 메소드
			int total_page = 0;
	/*		if(noar_id.equals("")){ //아이디가 없으면
				noar_id ="%";
			}*/
			total_page = (int) client.queryForObject("totalArticle_seq",noar_id);//공지사항의 모든 행을 가지고옴
			return total_page; //행의갯수 리턴
		}
		
		
		//페이징 하기위한 메서드 subject
		public int totalArticle_subject(String noar_id)throws SQLException{//게시글의모든 갯수를 가져오는 메소드
			int total_page = 0;
			if(noar_id.equals("")){ //아이디가 없으면
				noar_id ="%";
			}
			total_page = (Integer)client.queryForObject("totalArticle_subject",noar_id);//공지사항의 모든 행을 가지고옴
			return total_page; //행의갯수 리턴
		}
		
		//페이징 하기위한 메서드 content
		public int totalArticle_content(String noar_id)throws SQLException{//게시글의모든 갯수를 가져오는 메소드
			int total_page = 0;
			if(noar_id.equals("")){ //아이디가 없으면
				noar_id ="%";
			}
			total_page = (Integer)client.queryForObject("totalArticle_content",noar_id);//공지사항의 모든 행을 가지고옴
			return total_page; //행의갯수 리턴
		}

	
	
	@Override
	public String pageNumber(int tpage, String noar_id) throws SQLException {
		String str="";
		
		//6
		int total_pages = totalArticle(noar_id); 
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
			str += "<a href='articleView?tpage=1&key=" + noar_id
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='articleView.did?tpage=" + (start_page - 1);
			str += "&key=<%=noar_id%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='articleView?tpage=" + i + "&key="
						+ noar_id + "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='articleView?tpage=" + (end_page + 1)
					+ "&key=" + noar_id + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='articleView?tpage=" + page_count
					+ "&key=" + noar_id + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		
		
		System.out.println("tpage" + tpage);
		System.out.println("end_page" + end_page);
		System.out.println("page_count" + page_count);
		System.out.println("start_page" + start_page);
		System.out.println("total_pages" + total_pages);
	
		return str;
	    
	}

	@Override
	public ArrayList<Notice_ArticleVO> listArticlelist(int tpage, String noar_id)
			throws SQLException {
		int startRow = -1;
		int endRow = -1;

		if (noar_id == "") {
			noar_id = "%";
		}
		
		int totalRecord = totalArticle(noar_id);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;
		ArrayList<Notice_ArticleVO> articleView = (ArrayList<Notice_ArticleVO>) client
				.queryForList("listArticlelist", noar_id, startRow,counts);
		return articleView;
	}

	@Override
	public int articleCnt(int noar_seq) throws SQLException {
		return client.update("articleCnt",noar_seq);
	}


	@Override
	public ArrayList<Notice_ArticleVO> articleSearch_seq(int noar_seq)
			throws SQLException {
	
	ArrayList<Notice_ArticleVO> articleList =(ArrayList<Notice_ArticleVO>)client.queryForList("articleSearch_seq", noar_seq);
		return articleList;
	}

	@Override
	public ArrayList<Notice_ArticleVO> articleSearch_subject(String noar_seq)
			throws SQLException {
		ArrayList<Notice_ArticleVO> articleList =(ArrayList<Notice_ArticleVO>)client.queryForList("articleSearch_subject", noar_seq);
		return articleList;
	}

	@Override
	public ArrayList<Notice_ArticleVO> articleSearch_content(String noar_seq)
			throws SQLException {
		ArrayList<Notice_ArticleVO> articleList =(ArrayList<Notice_ArticleVO>)client.queryForList("articleSearch_content", noar_seq);
		return articleList;
	}

	@Override
	public String totalPage_seq(int tpage, int noar_seq) throws SQLException {
		String str="";
		
		//6
		int total_pages = totalArticle(noar_seq); 
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
			str += "<a href='articleView?tpage=1&key=" + noar_seq
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='articleView.did?tpage=" + (start_page - 1);
			str += "&key=<%=noar_id%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='articleView?tpage=" + i + "&key="
						+ noar_seq + "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='articleView?tpage=" + (end_page + 1)
					+ "&key=" + noar_seq + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='articleView?tpage=" + page_count
					+ "&key=" + noar_seq + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		

		return str;
	}
 
	@Override
	public String totalPage_subject(int tpage, String noar_subject)
			throws SQLException {
String str="";
		
		//6
		int total_pages = totalArticle_subject(noar_subject); 
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
			str += "<a href='articleView?tpage=1&key=" + noar_subject
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='articleView.did?tpage=" + (start_page - 1);
			str += "&key=<%=noar_id%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='articleView?tpage=" + i + "&key="
						+ noar_subject + "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='articleView?tpage=" + (end_page + 1)
					+ "&key=" + noar_subject + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='articleView?tpage=" + page_count
					+ "&key=" + noar_subject + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		
		return str;
	    
	}

	@Override
	public String totalPage_content(int tpage, String noar_content)
			throws SQLException {
String str="";
		
		//6
		int total_pages = totalArticle_content(noar_content); 
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
			str += "<a href='articleView?tpage=1&key=" + noar_content
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='articleView.did?tpage=" + (start_page - 1);
			str += "&key=<%=noar_id%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='articleView?tpage=" + i + "&key="
						+ noar_content + "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='articleView?tpage=" + (end_page + 1)
					+ "&key=" + noar_content + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='articleView?tpage=" + page_count
					+ "&key=" + noar_content + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
	
		return str;
	    
	}

	@Override
	public ArrayList<Notice_ArticleVO> listArticlelist_seq(int tpage,
			int noar_id) throws SQLException {
		int startRow = -1;
		int endRow = -1;

	/*	if (noar_id == "") {
			noar_id = "%";
		}
		*/
		int totalRecord = totalArticle(noar_id);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;
		ArrayList<Notice_ArticleVO> articleView = (ArrayList<Notice_ArticleVO>) client
				.queryForList("listArticlelist_seq", noar_id, startRow,counts);
		return articleView;
	}

	@Override
	public ArrayList<Notice_ArticleVO> listArticlelist_subject(int tpage,
			String noar_id) throws SQLException {
		int startRow = -1;
		int endRow = -1;

		if (noar_id == "") {
			noar_id = "%";
		}
		
		int totalRecord = totalArticle(noar_id);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;
		ArrayList<Notice_ArticleVO> articleView = (ArrayList<Notice_ArticleVO>) client
				.queryForList("listArticlelist_subject", noar_id, startRow,counts);
		return articleView;
	}

	@Override
	public ArrayList<Notice_ArticleVO> listArticlelist_content(int tpage,
			String noar_id) throws SQLException {
		int startRow = -1;
		int endRow = -1;

	/*	if (noar_id == "") {
			noar_id = "%";
		}
		*/
		int totalRecord = totalArticle(noar_id);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;
		ArrayList<Notice_ArticleVO> articleView = (ArrayList<Notice_ArticleVO>) client
				.queryForList("listArticlelist_content", noar_id, startRow,counts);
		return articleView;
	}

	@Override
	public void iconUpdate(int noar_seq) throws SQLException {
		
		client.update("iconUpdate", noar_seq);
	}

	@Override
	public void iconUpdate_n(int noar_seq) throws SQLException {
		client.update("iconUpdate_n", noar_seq);
	
	}




}