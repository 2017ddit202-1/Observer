package com.ddit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ddit.dto.AuthorityVO;
import com.ddit.service.AuthorityServiceImpl;

@Controller
@RequestMapping("/atrt")
public class AuthorityController {
	
	

	@Autowired
	private AuthorityServiceImpl authorityService;

	public void setAuthorityService(AuthorityServiceImpl authorityService) {
		this.authorityService = authorityService;
	}


	//권한신청
	@RequestMapping("/authorityReq")
	public String authorityReq(HttpSession session, HttpServletRequest request){
		String url="mypage";
		
		String userid=(String)session.getAttribute("loginUser");
		try {
			authorityService.AuthorityInsert(userid); //권한 인서트
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AuthorityVO authority= new AuthorityVO();
		try {
			authority=authorityService.authorityYN(userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(authority);
		request.setAttribute("authority", authority);
		
		
		return url;
	}

}
