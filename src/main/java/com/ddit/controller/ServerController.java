package com.ddit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/server")
public class ServerController {

	@RequestMapping("/serverMain")
	public String test(HttpServletRequest request, HttpServletResponse response,
			Model model, HttpSession session){
		String url = "server/serverMain";
		String loginUser = (String) session.getAttribute("loginUser");
	      String userOK = null;

	      try {
	         userOK = alertService.select_sessionID(loginUser);
	         alertService.alertDelete(loginUser);
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }

	      if (userOK != null) {
	         model.addAttribute("userOK",userOK);
	      }
		
		return url;
		
		
	}
	
	
	
}
