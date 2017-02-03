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



	@Override
	public int deleteArticle(int noar_seq) throws SQLException {
		int result=articleDAO.deleteArticle(noar_seq);
		return result;
	}



	@Override
	public void updateArticle(Notice_ArticleVO articleVO)
			throws SQLException {
	articleDAO.updateArticle(articleVO);
		
	}



	@Override
	public String totalPage(int tpage, String noar_id) throws SQLException {
		String str = articleDAO.pageNumber(tpage, noar_id);
		return str;
	}



	@Override
	public ArrayList<Notice_ArticleVO> listArticlelist(int tpage, String noar_id)
			throws SQLException {
		ArrayList<Notice_ArticleVO> list = articleDAO.listArticlelist(tpage, noar_id);
		return list;
	}



	@Override
	public int articleCnt(int noar_seq) throws SQLException {
		
		return articleDAO.articleCnt(noar_seq);
	}



}
