package com.ddit.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ViewResolver;

import com.ddit.dto.MemberVO;
import com.ddit.dto.QnaVO;
import com.ddit.service.QnaService;


@Controller
@RequestMapping("/qna")
public class QnaController {
	@Autowired
	QnaService qnaService;
	
	
	
	

	
	
	/*@RequestMapping(value="/qnaList", method=RequestMethod.GET)*/
	@RequestMapping("/qnaList")
	public String qnaList(/*@RequestParam("qseq") int qseq,*/
			HttpSession session, Model model, HttpServletRequest request){
		
		String url = "qna/qnaList";
		String key = "";
		String tpage = request.getParameter("tpage");
		if (request.getParameter("key") != null) {
			key = request.getParameter("key");
		}
		
		if (tpage == null) {
			tpage = "1"; // ���� ������ (default 1)
		} else if (tpage.equals("")) {
			tpage = "1";
		}
		
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		System.out.println(memberVO.getMem_id());
		ArrayList<QnaVO> qnaList=null;
		String paging = null;
		//
		
		try {
			qnaList = qnaService.listqnalist(Integer.parseInt(tpage), key);
			paging = qnaService.totalPage(Integer.parseInt(tpage), key);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int n = qnaList.size();
		
		model.addAttribute("qnaList", qnaList);
		model.addAttribute("qnaListSize", n);
		model.addAttribute("paging", paging); 
		
		return url;
	}
	
	//qna 글 쓰기
	@RequestMapping("/qnaWriteForm")
	public String qnaWriteForm(HttpSession session, Model model
			 , HttpServletRequest request){
		
		String url = "/qna/qnaWriteForm";
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		return url;
	}
	
	
	@RequestMapping("/qnaWrite")
	public String qnaWrite(HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response){
		String url="redirect:/qna/qnaList";
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		response.setCharacterEncoding("utf-8");
		QnaVO qnaVO = new QnaVO();
		qnaVO.setQna_subject(((String)request.getParameter("subject")));
		qnaVO.setQna_content(((String)request.getParameter("content")));
		qnaVO.setQna_id(((String)request.getParameter("id")));
		System.out.println(qnaVO.getQna_subject());
		System.out.println(qnaVO.getQna_content());
		
		try {
			qnaService.insertQna(qnaVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//아직 못함
		}
		
		return url;
		
	}
	
	
}
