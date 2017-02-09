package com.ddit.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.ddit.dto.Notice_ArticleVO;
import com.ddit.service.Notice_ArticleService;

@Controller
@RequestMapping("/article")
public class NoticeArticleController {
	@Autowired
	Notice_ArticleService articleService;

	//공지사항 리스트
	@RequestMapping("/articleView")
	public String articleView(HttpServletRequest request,
			HttpServletResponse response,HttpSession session, Model model) {
		String url = "articleView";
		
		
		
		
		
      /////////////////페이징시작/////////////////////////
		String key="";
		String tpage = request.getParameter("tpage");
		if(request.getParameter("key") != null){
			key = request.getParameter("key");
		}
		if (tpage == null) {
			tpage = "1"; // ���� ������ (default 1)
		} else if (tpage.equals("")) {
			tpage = "1";
		}
		String id = (String) session.getAttribute("loginUser");

		ArrayList<Notice_ArticleVO> articleList = null;
		String paging = null;
		//

		
		//////////////////////////////////////////////////

		
		try {
			/*articleList = articleService.listAllArticle();*/
			articleList = articleService.listArticlelist(Integer.parseInt(tpage),key);
			paging = articleService.totalPage(Integer.parseInt(tpage),key);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int n = articleList.size();
		/*session.setAttribute("articleList", articleList);*/
		/*request.setAttribute("articleList", articleList);*/

		System.out.println(paging+"&&@@");
		System.out.println(n);
		System.out.println(key);
		System.out.println(tpage);
		
		model.addAttribute("articleList", articleList);
		model.addAttribute("qnaListSize", n);
		model.addAttribute("paging", paging);
		
		session.getAttribute("loginUser");


		return url;

	}
	
	//공지사항글쓰기
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
		String url = "articleView";
		HttpSession session = request.getSession();
		Notice_ArticleVO articleVO = new Notice_ArticleVO();
		articleVO.setNoar_id(request.getParameter("noar_id"));
		articleVO.setNoar_subject(request.getParameter("noar_subject"));
		articleVO.setNoar_content(request.getParameter("noar_content"));
		
		
		ArrayList<Notice_ArticleVO> articleList = null;
		try {
			articleService.insertArticle(articleVO);
			articleList = articleService.listAllArticle();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("articleList", articleList);
		
		return url;
	}
	
	//공지사항 디테일
	@RequestMapping(value="/detailArticle", method=RequestMethod.GET)
	public String detailArticle(HttpServletRequest request,
			HttpServletResponse response, HttpSession session){
		String url="detailArticle";
		
		String noar_seq = request.getParameter("noar_seq");
		int seq=Integer.parseInt(noar_seq);
		Notice_ArticleVO articleVO=null;
		try {
			articleVO=articleService.detailArticle(Integer.parseInt(noar_seq));
		    articleService.articleCnt(seq);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*session.setAttribute("articleVO", articleVO);*/
		request.setAttribute("articleVO", articleVO);
		
		
		return url;
	}
	
	//공지글 삭제
	@RequestMapping("/articleDelete")
	public String articleDelete(HttpServletRequest request,
			HttpServletResponse response, HttpSession session){
		String url ="articleView";
	
		String noar_seq=request.getParameter("noar_seq");
	
		Notice_ArticleVO articleVO=null;
		System.out.println(noar_seq);
		ArrayList<Notice_ArticleVO> articleList = null;
		try {
			articleService.deleteArticle(Integer.parseInt(noar_seq));
			articleList=articleService.listAllArticle();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*System.out.println(articleList);
		*/
		request.setAttribute("articleList", articleList);
		return url;
		
	}
	
	//공지사항 수정
	@RequestMapping(value="/articleUpdate", method=RequestMethod.POST)
	public String articleUpdate(HttpServletRequest request,
			HttpServletResponse response, HttpSession session){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		String url="articleView";
		
		Notice_ArticleVO articleVO = new Notice_ArticleVO();
		articleVO.setNoar_subject(request.getParameter("noar_subject"));
		articleVO.setNoar_content(request.getParameter("noar_content"));
		articleVO.setNoar_seq(Integer.parseInt(request.getParameter("noar_seq")));
	
		ArrayList<Notice_ArticleVO> articleList = null;
		try {
			articleService.updateArticle(articleVO);
			articleList=articleService.listAllArticle();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("articleList", articleList);
		
	

		return url;
	}
	
	
	//공지사항 서치
	@RequestMapping(value="/articleSearch", method=RequestMethod.POST)
	public String articleSearch(@RequestParam(required=false) String keyField, @RequestParam String keyWord, Model model
			,HttpServletRequest request){
		
		String url="articleView";
		
		ArrayList<Notice_ArticleVO> articleList= null;
		System.out.println(keyWord);
		if(keyField.equals("noar_seq")){
			int key=Integer.parseInt(keyWord);
			
			try {
				articleList=articleService.articleSearch_seq(key);
				model.addAttribute("articleSearch", articleList);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(keyField.equals("noar_subject")){
			try {
				articleList=articleService.articleSearch_subject(keyWord);
				model.addAttribute("articleList", articleList);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			try {
				articleList=articleService.articleSearch_content(keyWord);
				model.addAttribute("articleList",articleList);
				model.addAttribute(keyField);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
		return url;
	}
	
	
}




















