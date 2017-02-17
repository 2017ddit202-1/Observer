package com.ddit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller 
@RequestMapping("/test")
public class test { 
	
	
	  // path="/test/authority" 매핑값으로 들어오면 소켓인터셉터 연결
	@RequestMapping("/authority")
	public String management(HttpServletRequest request, HttpSession session) {
		String url = "/test";
		
		String[] chkbox = request.getParameterValues("mem_id");

		session.setAttribute("chkbox", chkbox);
		
		
		return url;
	}

}
