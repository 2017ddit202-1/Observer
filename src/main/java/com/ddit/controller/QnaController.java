package com.ddit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ddit.dto.QnaVO;
import com.ddit.service.QnaService;


@Controller
@RequestMapping("/qna")
public class QnaController {
	@Autowired
	QnaService qnaService;
	
	@RequestMapping("/qnaView")
	public String qnaView(
			HttpSession session, Model model){
		
		String url = "qna/qnaView";
		
		QnaVO qnaVO=null;
		try {
			qnaVO = qnaService.getQna(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("qnaVO", qnaVO);
		return url;
	}
	
}
