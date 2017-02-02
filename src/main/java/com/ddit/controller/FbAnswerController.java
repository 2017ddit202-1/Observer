package com.ddit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.record.FnGroupCountRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ddit.dto.FbanswerVO;
import com.ddit.dto.FreeBoardVO;
import com.ddit.service.FbanswerServiceImpl;

@Controller
@RequestMapping("/fbAns")
public class FbAnswerController {

	@Autowired
	private FbanswerServiceImpl fbanswerService;
	public void setFbanswerService(FbanswerServiceImpl fbanswerService){
		this.fbanswerService = fbanswerService;
	}
	
//	@RequestMapping("/fbAnsWriteForm")
//	public String fbAnsWriteForm(HttpSession session , HttpServletRequest request , Model model){
//		String url = "/fbAnsWriteForm";
//		String id = (String) session.getAttribute("loginUser");
//		String fb_seq = request.getParameter("fb_seq");
//		
//		model.addAttribute("fb_seq",fb_seq);
//		return url;
//	}
	
	@RequestMapping(value ="/fbAnsWrite" , method=RequestMethod.POST,produces="application/text;charset=utf8")
	public String fbAnsWrite(HttpServletRequest request , HttpServletResponse response , HttpSession session , Model model){

		String userId = (String) session.getAttribute("loginUser");
		String fb_seq = request.getParameter("fb_seq");
		
		FbanswerVO fbAnsVO = null;
		fbAnsVO.setFbans_id(userId);
		fbAnsVO.setFbans_content(request.getParameter("content"));
		fbAnsVO.setFbans_fbseq(Integer.parseInt(fb_seq));
		
		System.out.println(fbAnsVO);
		
		try {
			fbanswerService.insertFbanswer(fbAnsVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
