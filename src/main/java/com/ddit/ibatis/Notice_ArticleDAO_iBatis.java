package com.ddit.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.Notice_ArticleDAO;
import com.ddit.dto.Notice_ArticleVO;
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
	


}
