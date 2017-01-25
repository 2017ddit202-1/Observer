package com.ddit.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ddit.dto.Notice_ArticleVO;
import com.ddit.service.Notice_ArticleService;
import com.ddit.service.QnaService;

@Controller
@RequestMapping("/article")
public class NoticeArticleController {
	@Autowired
	Notice_ArticleService articleService;

	//공지사항 리스트
	@RequestMapping("/articleView")
	public String articleView(HttpSession session, Model model) {
		String url = "articleView";

		ArrayList<Notice_ArticleVO> articleList = null;
		try {
			articleList = articleService.listAllArticle();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("articleList", articleList);

		return url;

	}
	
	@RequestMapping(value="/articleWrite", method= RequestMethod.GET)
	public String articleWrite1(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		String url = "articleWrite";
		return url;
	}
	

	//공지사항글쓰기
	@RequestMapping(value="/articleWrite", method= RequestMethod.POST)
	public String articleWrite(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String url = "articleWrite";
		HttpSession session = request.getSession();
		Notice_ArticleVO articleVO = new Notice_ArticleVO();
		articleVO.setNoar_id(request.getParameter("noar_id"));
		articleVO.setNoar_subject(request.getParameter("noar_subject"));
		articleVO.setNoar_content(request.getParameter("noar_content"));
		
		try {
			articleService.insertArticle(articleVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return url;
	}
	
	//공지사항 디테일
	@RequestMapping(value="/detailArticle", method=RequestMethod.GET)
	public String detailArticle(HttpServletRequest request,
			HttpServletResponse response, HttpSession session){
		String url="detailArticle";
		
		String noar_seq = request.getParameter("noar_seq");
		Notice_ArticleVO articleVO=null;
		try {
			articleVO=articleService.detailArticle(Integer.parseInt(noar_seq));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("articleVO", articleVO);
		
		return url;
	}
}




















