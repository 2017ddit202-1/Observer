package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ddit.dto.Notice_ArticleVO;

public interface Notice_ArticleService {
	public ArrayList<Notice_ArticleVO> listAllArticle() throws SQLException;
	public int insertArticle(Notice_ArticleVO articleVO) throws SQLException;
	public Notice_ArticleVO detailArticle(int noar_seq)throws SQLException;
	public int deleteArticle(int noar_seq)throws SQLException;
	public void updateArticle(Notice_ArticleVO articleVO)throws SQLException;
	public String totalPage(int tpage, String noar_id) throws SQLException;
	
	
	public String totalPage_seq(int tpage, int noar_seq) throws SQLException;//페이징
	public String totalPage_subject(int tpage, String noar_subject) throws SQLException;//페이징
	public String totalPage_content(int tpage, String noar_content) throws SQLException;//페이징
	

	
	public ArrayList<Notice_ArticleVO> listArticlelist(int tpage,String noar_id) throws SQLException;
	public ArrayList<Notice_ArticleVO> listArticlelist_seq(int tpage,int noar_id) throws SQLException;
	public ArrayList<Notice_ArticleVO> listArticlelist_subject(int tpage,String noar_id) throws SQLException;
	public ArrayList<Notice_ArticleVO> listArticlelist_content(int tpage,String noar_id) throws SQLException;
	
	
	
	public int articleCnt(int noar_seq)throws SQLException;
	public ArrayList<Notice_ArticleVO> articleSearch_seq(int noar_seq)throws SQLException; //서치(시퀀스)
	public ArrayList<Notice_ArticleVO> articleSearch_subject(String noar_seq)throws SQLException; //서치(제목)
	public ArrayList<Notice_ArticleVO> articleSearch_content(String noar_seq)throws SQLException; //서치(내용)
}