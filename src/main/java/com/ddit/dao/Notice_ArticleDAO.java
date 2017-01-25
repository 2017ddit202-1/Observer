package com.ddit.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.Notice_ArticleVO;



public interface Notice_ArticleDAO {
	
	public ArrayList<Notice_ArticleVO> listAllArticle() throws SQLException;
	public int insertArticle(Notice_ArticleVO articleVO) throws SQLException;
	public Notice_ArticleVO detailArticle(int noar_seq)throws SQLException;
	public int deleteArticle(int noar_seq)throws SQLException;
	public void updateArticle(Notice_ArticleVO articleVO)throws SQLException;
	
	

}
