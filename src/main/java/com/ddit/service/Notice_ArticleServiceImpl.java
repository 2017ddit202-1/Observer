package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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



	@Override
	public ArrayList<Notice_ArticleVO> articleSearch_seq(int noar_seq)
			throws SQLException {
		ArrayList<Notice_ArticleVO> articleList =articleDAO.articleSearch_seq(noar_seq);
		return articleList;
	}



	@Override
	public ArrayList<Notice_ArticleVO> articleSearch_subject(String noar_seq)
			throws SQLException {
		ArrayList<Notice_ArticleVO> articleList =articleDAO.articleSearch_subject(noar_seq);
		return articleList;
	}



	@Override
	public ArrayList<Notice_ArticleVO> articleSearch_content(String noar_seq)
			throws SQLException {
		ArrayList<Notice_ArticleVO> articleList =articleDAO.articleSearch_content(noar_seq);
		return articleList;
	}



	@Override
	public String totalPage_seq(int tpage, int noar_seq) throws SQLException {
		return articleDAO.totalPage_seq(tpage, noar_seq);
	}



	@Override
	public String totalPage_subject(int tpage, String noar_subject)
			throws SQLException {
	return articleDAO.totalPage_subject(tpage, noar_subject);
	}



	@Override
	public String totalPage_content(int tpage, String noar_content)
			throws SQLException {
		return articleDAO.totalPage_content(tpage, noar_content);
	}



	@Override
	public ArrayList<Notice_ArticleVO> listArticlelist_seq(int tpage,
			int noar_id) throws SQLException {
		ArrayList<Notice_ArticleVO> list = articleDAO.listArticlelist_seq(tpage, noar_id);
		return list;
	}



	@Override
	public ArrayList<Notice_ArticleVO> listArticlelist_subject(int tpage,
			String noar_id) throws SQLException {
		ArrayList<Notice_ArticleVO> list = articleDAO.listArticlelist_subject(tpage, noar_id);
		return list;
	}



	@Override
	public ArrayList<Notice_ArticleVO> listArticlelist_content(int tpage,
			String noar_id) throws SQLException {
		ArrayList<Notice_ArticleVO> list = articleDAO.listArticlelist_content(tpage, noar_id);
		return list;
	}



	@Override
	public void iconUpdate(int noar_seq) throws SQLException {
		articleDAO.iconUpdate(noar_seq);
		
	}



	@Override
	public void iconUpdate_n(int noar_seq) throws SQLException {
		articleDAO.iconUpdate_n(noar_seq);
	}







}