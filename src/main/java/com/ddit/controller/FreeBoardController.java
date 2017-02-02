package com.ddit.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ddit.dto.FreeBoardVO;
import com.ddit.dto.MemberVO;
import com.ddit.service.FreeBoardServiceImpl;
import com.ddit.service.MemberServiceImpl;

@Controller
@RequestMapping("/fb")
public class FreeBoardController {

	@Autowired
	private FreeBoardServiceImpl freeBoardServiceImpl;
	public void setFreeBoardServiceImpl(FreeBoardServiceImpl freeBoardServiceImpl){
		this.freeBoardServiceImpl = freeBoardServiceImpl;
	}
	@Autowired
	private MemberServiceImpl memberService;
	public void setMemberService(MemberServiceImpl memberService){
		this.memberService = memberService;
	}
	
	
	
	@RequestMapping("/fbList")
	public String fbList(HttpServletRequest request , HttpSession session , Model model){
		String url = "/fbList";
		
		String id = (String) session.getAttribute("loginUser");
		ArrayList<FreeBoardVO> fbList = null;
		
		try {
			fbList = freeBoardServiceImpl.listAllFb();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int size = fbList.size();
		
		model.addAttribute("fbList",fbList);
		model.addAttribute("fbListSize",size);
		session.getAttribute("loginUser");
		
		return url;		
	}
	
	@RequestMapping("/fbWriteForm")
	public String fbWriteForm(HttpSession session){
		String url = "/fbWriteForm";
		String id = (String) session.getAttribute("loginUser");
		return url;
	}
	
	@RequestMapping("/fbWrite")
	public String fbWrite(HttpSession session , HttpServletRequest request , HttpServletResponse response , Model model){
		String url = "redirect:/fb/fbList";
		
		FreeBoardVO fbVO = new FreeBoardVO();
		fbVO.setFb_id((String)session.getAttribute("loginUser"));
		fbVO.setFb_subject(request.getParameter("subject"));
		fbVO.setFb_content(request.getParameter("content"));
		
		
		try {
			freeBoardServiceImpl.insertFb(fbVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return url;
	}
	
	@RequestMapping("/fbDetail")
	public String detailFb(HttpSession session , HttpServletRequest request , HttpServletResponse response,
							Model model){
		String url = "/fbDetail";
	
		String fb_seq = request.getParameter("fb_seq");
		FreeBoardVO fbVO = null;
		
		try {
			fbVO = freeBoardServiceImpl.fbDetail(Integer.parseInt(fb_seq));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("fbVO",fbVO);
		
		return url;
		
	}
	
	@RequestMapping("/fbDelete")
	public String fbDelete(HttpServletRequest request , HttpServletResponse response , HttpSession session , Model model){
		String url = "redirect:/fb/fbList";
		int fb_seq = Integer.parseInt(request.getParameter("fb_seq"));
		int result = 0;
		ArrayList<FreeBoardVO> fbList = null;
		
		try {
			result = freeBoardServiceImpl.deleteFb(fb_seq);
			fbList = freeBoardServiceImpl.listAllFb();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		request.setAttribute("fbList", fbList);
		model.addAttribute("fbList",fbList);
		
		return url;
	}
	
	@RequestMapping(value = "/fbUpdate" , method=RequestMethod.POST)
	public String fbUpdate(HttpServletRequest request , HttpServletResponse response , HttpSession session , Model model){
		String url = "redirect:/fb/fbList";
		
		FreeBoardVO fbVO = new FreeBoardVO();
		
		fbVO.setFb_id((String)session.getAttribute("loginUser"));
		fbVO.setFb_subject(request.getParameter("fb_subject"));
		fbVO.setFb_content(request.getParameter("fb_content"));
		fbVO.setFb_seq(Integer.parseInt(request.getParameter("fb_seq")));
		
		ArrayList<FreeBoardVO> fbList = null;
		
		try {
			fbList = freeBoardServiceImpl.listAllFb();
			freeBoardServiceImpl.updateFb(fbVO);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("fbList",fbList);
//		session.getAttribute("loginUser");
		
		return url;
	}

}
