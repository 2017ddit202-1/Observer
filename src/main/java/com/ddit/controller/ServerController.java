package com.ddit.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ddit.service.AlertServiceImpl;
import com.google.gson.Gson;

@Controller
@RequestMapping("/server")
public class ServerController {
	Map<String,String> map = new HashMap<String,String>();
	static String  classip = null;
	String classHost = null;
	
	@Autowired
	private AlertServiceImpl alertService;

	public void setAlertService(AlertServiceImpl alertService) {
		this.alertService = alertService;
	}

	@RequestMapping(value = "/serverMain", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String test(HttpServletRequest request,
			HttpServletResponse response, Model model, HttpSession session) {
		String url = "server/serverMain";
		List<String> iplist = new ArrayList<String>();
		System.out.println("테스트중입니다. 파라미터 ip"+(String)request.getParameter("ip"));
		System.out.println("테스트중입니다. 파라미터 hostname"+(String)request.getParameter("hostName"));
		classip = (String)request.getParameter("ip");
		classHost = (String)request.getParameter("hostName");
		
		
		System.out.println(classip + "()()()()");
		System.out.println(classHost + "()()()()()");
		
		String loginUser = (String) session.getAttribute("loginUser");
		String userOK = null;
		String column = "";
		
		try {
			userOK = alertService.select_sessionID(loginUser); // alert테이블에 ID값이
																// 존재하는지 select
			column = alertService.authority_content(loginUser);
			alertService.alertDelete(loginUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (userOK != null) {// 값이 있으면

			if (column.equals("거절")) {
				column = "권한신청이 거절되었습니다.";
			} else if (column.equals("ROLE_ADMIN")) {
				column = "ADMIN으로 등급신청 완료";
			} else if (column.equals("ROLE_USER")) {
				column = "USER로 등급신청 완료";
			}

			model.addAttribute("userOK", userOK);
			model.addAttribute("column", column);
		}

	
		
		map.put("ip", classip);
		map.put("host", classHost);
		model.addAttribute("classip", classip);
		model.addAttribute("classHost", classHost);
		model.addAttribute("map", map);
		
		
		return url;

	}

	/*@RequestMapping("testForm")
	public String test(HttpServletRequest request, HttpServletResponse response) {
		String url = "server/testGetForm";
		System.out.println("GETFORM()()");
		return url;
	}*/

	/*@RequestMapping(value = "getServer", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getServer(
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("GET Server Response");
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		map.put("ip", request.getParameter("ip"));
		map.put("hostName", request.getParameter("hostName"));
		map.put("flag", "get");
		map.put("success", true);  
		
		return map;

	}*/

	 
}
