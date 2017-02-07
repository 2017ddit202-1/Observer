package com.ddit.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ddit.dto.Vw_AuthorityVO;
import com.ddit.service.AuthorityServiceImpl;

@Controller
@RequestMapping("/superAdmin")
public class SuperAdminController {
	
	
	@Autowired
	private AuthorityServiceImpl authorityService;


	public void setAuthorityService(AuthorityServiceImpl authorityService) {
		this.authorityService = authorityService;
	}
	
	
	//관리페이지
	@RequestMapping("/management")
	public String management(){
		String url="/superAdmin/management";
		
		return url;
	}
	
	//권한요청목록
	@RequestMapping("/authorityList")
	public String authorityList(){
		String url="/superAdmin/authorityList";
		
		ArrayList<Vw_AuthorityVO> su_authorityList=null;
		
		try {
			su_authorityList=authorityService.authorityList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("권한요청목록");
		System.out.println(su_authorityList);
		return url;
	}

}
