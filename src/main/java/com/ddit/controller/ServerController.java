package com.ddit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/server")
public class ServerController {

	@RequestMapping("/serverMain")
	public String test(HttpServletRequest request, HttpServletResponse response, Model model){
		String url = "server/serverMain";
		
		//서버와 연결된 내용들을 db에 저장
		String a = "박불휘";
		model.addAttribute("test", a);
		
		
		
		
		return url;
		
		
	}
	
	
	
	
	
}
