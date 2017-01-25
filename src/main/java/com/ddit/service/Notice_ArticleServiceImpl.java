package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dao.Notice_ArticleDAO;
import com.ddit.dto.Notice_ArticleVO;
import com.ddit.ibatis.MemberDAO_iBatis;
import com.ddit.ibatis.Notice_ArticleDAO_iBatis;

public class Notice_ArticleServiceImpl implements Notice_ArticleService{

	
	Notice_ArticleDAO articleDAO;
	
	public void setArticleDAO(Notice_ArticleDAO articleDAO){
		this.articleDAO = articleDAO;
	}
	
	
	
	@Override
	public ArrayList<Notice_ArticleVO> listAllArticle() throws SQLException {
		
		ArrayList<Notice_ArticleVO> articleVO = null;
		 articleVO = articleDAO.listAllArticle();
		return articleVO;
	}



	@Override
	public int insertArticle(Notice_ArticleVO articleVO) throws SQLException {
		int result=articleDAO.insertArticle(articleVO);
		return result;
	}



	@Override
	public Notice_ArticleVO detailArticle(int noar_seq) throws SQLException {
		Notice_ArticleVO articleVO = articleDAO.detailArticle(noar_seq);
		return articleVO;
	}



}
