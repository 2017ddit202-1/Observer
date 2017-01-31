package com.ddit.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ddit.dto.FreeBoardVO;
import com.ddit.service.FreeBoardServiceImpl;

@Controller
@RequestMapping("/fb")
public class FreeBoardController {

	@Autowired
	private FreeBoardServiceImpl freeBoardServiceImpl;
	public void setFreeBoardServiceImpl(FreeBoardServiceImpl freeBoardServiceImpl){
		this.freeBoardServiceImpl = freeBoardServiceImpl;
	}
	
	@RequestMapping("/fbList")
	public String fbList(HttpServletRequest request , HttpSession session , Model model){
		String url = "/fbList";
		
		String id = (String) request.getAttribute("loginUser");
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
	

}
