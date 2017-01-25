package com.ddit.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ddit.dto.Notice_ArticleVO;

public interface Notice_ArticleService {
	public ArrayList<Notice_ArticleVO> listAllArticle() throws SQLException;
	public int insertArticle(Notice_ArticleVO articleVO) throws SQLException;
	public Notice_ArticleVO detailArticle(int noar_seq)throws SQLException;
}
