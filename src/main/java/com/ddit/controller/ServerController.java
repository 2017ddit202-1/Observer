package com.ddit.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ddit.service.AlertServiceImpl;

@Controller
@RequestMapping("/server")
public class ServerController {

   @Autowired
   private AlertServiceImpl alertService;

   public void setAlertService(AlertServiceImpl alertService) {
      this.alertService = alertService;
   }

   @RequestMapping(value="/serverMain",method = RequestMethod.GET, produces = "application/text;charset=utf8")
   public String test(HttpServletRequest request,
         HttpServletResponse response, Model model, HttpSession session) {
      String url = "server/serverMain";
      List<String> iplist = new ArrayList<String>();
      
      System.out.println("serverController");
		String loginUser = (String) session.getAttribute("loginUser");
		String userOK = null;
		String column="";
		///////
		request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		String ip = request.getHeader("X-FORWARDED-FOR");
		String host = request.getRemoteHost();
		
		
		
		
		if(ip == null){
			ip = request.getRemoteAddr();
		}
		
		
		iplist.add(ip);
		
		
		try {
			userOK = alertService.select_sessionID(loginUser);  //alert테이블에 ID값이 존재하는지 select
			column=alertService.authority_content(loginUser);
			alertService.alertDelete(loginUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (userOK != null) {//값이 있으면
			
			if(column.equals("거절")){
				column ="권한신청이 거절되었습니다.";
			}else if (column.equals("ROLE_ADMIN")) {
				column ="ADMIN으로 등급신청 완료";
			}else if(column.equals("ROLE_USER")){
				column ="USER로 등급신청 완료";
			}
			
			model.addAttribute("userOK",userOK);
			model.addAttribute("column", column);
		}
		
		
		
		model.addAttribute("iplist",iplist);
		
		
      return url;

   }
   
   

}
