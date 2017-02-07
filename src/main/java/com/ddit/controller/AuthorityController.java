package com.ddit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ddit.service.AuthorityServiceImpl;

@Controller
@RequestMapping("/atrt")
public class AuthorityController {
	
	

	@Autowired
	private AuthorityServiceImpl authorityService;


	public void setAuthorityService(AuthorityServiceImpl authorityService) {
		this.authorityService = authorityService;
	}


	@RequestMapping("/authorityReq")
	public String authorityReq(HttpSession session){
		String url="";
		
		String userid=(String)session.getAttribute("loginUser");
		try {
			authorityService.AuthorityInsert(userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}

}
