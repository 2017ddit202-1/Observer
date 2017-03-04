package com.ddit.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddit.dto.FbanswerVO;
import com.ddit.dto.FreeBoardVO;
import com.ddit.dto.MemberVO;
import com.ddit.service.FbanswerServiceImpl;
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
		
		String key = "";
		String tpage = request.getParameter("tpage");
		if (request.getParameter("key") != null) {
			key = request.getParameter("key");
		}
		if (tpage == null) {
			tpage = "1"; 
		} else if (tpage.equals("")) {
			tpage = "1";
		}
		
		String id = (String) session.getAttribute("loginUser");
		
		ArrayList<FreeBoardVO> fbList = null;
		String paging = null;
		
		try {
			fbList = freeBoardServiceImpl.listFbPage(Integer.parseInt(tpage), key);
			paging = freeBoardServiceImpl.pageNumber(Integer.parseInt(tpage), key);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int size = fbList.size();
		
		model.addAttribute("fbList",fbList);
		model.addAttribute("fbListSize",size);
		model.addAttribute("paging",paging);
		model.addAttribute("tpage",tpage);
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
		String tpage = request.getParameter("tpage"); 
		String fb_seq = request.getParameter("fb_seq");
		FreeBoardVO fbVO = null;
		
		try {
			fbVO = freeBoardServiceImpl.fbDetail(Integer.parseInt(fb_seq));
			freeBoardServiceImpl.fb_cnt(Integer.parseInt(fb_seq));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("fbVO",fbVO);
		model.addAttribute("tpage",tpage);
		return url;
		
	}
	
	@RequestMapping("/fbDelete")
	public String fbDelete(HttpServletRequest request , HttpServletResponse response , HttpSession session , Model model){
		String url = "redirect:/fb/fbList";
		int fb_seq = Integer.parseInt(request.getParameter("fb_fbseq"));
		int result = 0;
		ArrayList<FreeBoardVO> fbList = null;
		String tpage = request.getParameter("tpage"); 
		try {
			result = freeBoardServiceImpl.deleteFb(fb_seq);
			fbList = freeBoardServiceImpl.listAllFb();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		request.setAttribute("fbList", fbList);
		model.addAttribute("fbList",fbList);
		model.addAttribute("tpage",tpage);
		
		return url;
	}
	
	@RequestMapping(value = "/fbUpdate" , method=RequestMethod.POST)
	public String fbUpdate(HttpServletRequest request , HttpServletResponse response , HttpSession session , Model model){
		String url = "redirect:/fb/fbList";
		
		FreeBoardVO fbVO = new FreeBoardVO();
		String tpage = request.getParameter("tpage"); 
		fbVO.setFb_id((String)session.getAttribute("loginUser"));
		fbVO.setFb_subject(request.getParameter("fb_subject"));
		fbVO.setFb_content(request.getParameter("fb_content"));
		fbVO.setFb_seq(Integer.parseInt(request.getParameter("fb_fbseq")));
		
		ArrayList<FreeBoardVO> fbList = null;
		
		try {
			fbList = freeBoardServiceImpl.listAllFb();
			freeBoardServiceImpl.updateFb(fbVO);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("fbList",fbList);
		model.addAttribute("tpage",tpage);
//		session.getAttribute("loginUser");
		
		return url;
	}
	
	@RequestMapping(value="/fbSearch",method=RequestMethod.POST)
	public String fbSearch(Model model,HttpServletRequest request){
		String url = "fbList";
		
		String keyField = request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		
		String key = "";
		String tpage = request.getParameter("tpage");
		if (request.getParameter("keyWord") != null) {
			key = request.getParameter("keyWord");
		}
		if (tpage == null) {
			tpage = "1"; 
		} else if (tpage.equals("")) {
			tpage = "1";
		}
		
		model.addAttribute("tpage",tpage);
		
		
		
		ArrayList<FreeBoardVO> fbList = null;
		String paging = null;
		 if(keyField.equals("fb_sub")){
			try {
				fbList = freeBoardServiceImpl.searchSub(keyWord, Integer.parseInt(tpage));
				paging = freeBoardServiceImpl.pageNumberSub(Integer.parseInt(tpage), key);
				model.addAttribute("fbList",fbList);
				model.addAttribute("paging",paging);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(keyField.equals("fb_con")){
			try {
				fbList = freeBoardServiceImpl.searchCon(keyWord, Integer.parseInt(tpage));
				paging = freeBoardServiceImpl.pageNumberCon(Integer.parseInt(tpage), key);
				model.addAttribute("fbList",fbList);
				model.addAttribute("paging",paging);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(keyField.equals("fb_id")){
			try {
				fbList = freeBoardServiceImpl.searchId(keyWord, Integer.parseInt(tpage));
				paging = freeBoardServiceImpl.pageNumber(Integer.parseInt(tpage), key);
				model.addAttribute("fbList",fbList);
				model.addAttribute("paging",paging);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return url;
	}

}
