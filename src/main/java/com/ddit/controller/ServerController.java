package com.ddit.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ddit.dto.MemberVO;
import com.ddit.dto.ServerVO;
import com.ddit.service.AlertServiceImpl;
import com.ddit.service.MemberServiceImpl;

@Controller
@RequestMapping("/server")
public class ServerController {
	
	
	 Map<String,Map<String,String>> classMap = new LinkedHashMap<String,Map<String,String>>();
	
	 /*String  classip = "";
	
	String classHost = "";*/
	
	
	@Autowired
	private AlertServiceImpl alertService;
	
	
	@Autowired
	private MemberServiceImpl memberService;

	public void setAlertService(AlertServiceImpl alertService) {
		this.alertService = alertService;
	}

	/*
	 * if문으로 ip로 
	 */
	@RequestMapping(value = "/serverMain", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String test(HttpServletRequest request,
			HttpServletResponse response, Model model, HttpSession session) {
		String url = "server/serverMain";
		String currentip = request.getParameter("testIp");
		String saveyn = null;
		List<String> iplist = new ArrayList<String>();
		System.out.println("POST method");
		classMap = (Map<String, Map<String, String>>) request.getAttribute("classMap"); 
		System.out.println("dddddddd"+request.getAttribute("testIp"));
		System.out.println(classMap.toString() +"()()()()()(");
		System.out.println(classMap.toString() +"()()()()()(");
		
		Map<String,String> valueMap = classMap.get(currentip);
		
		//서버 table에서 currentip 로 셀렉해서 saveyn이 1이면
		valueMap.put("saveyn","1");
		classMap.put(currentip, valueMap);
		
		if(classMap.get(currentip).get("saveyn").equals("1")){
			//cpu 테이블에 인설트
		}
		 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/////////
		
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
		
		
		
		model.addAttribute("map", classMap);
		
		
		
		return url;

	}

	@RequestMapping(value = "/serverMain", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String test2(HttpServletRequest request,
			HttpServletResponse response, Model model, HttpSession session) {
		String url = "server/serverMain";
		System.out.println("GET method");
		List<String> iplist = new ArrayList<String>();
		
		/*classip = (String)session.getAttribute("ip");
		classHost = (String)session.getAttribute("hostName");*/
		classMap = (Map<String, Map<String, String>>) request.getAttribute("classMap"); 
		System.out.println(request.getAttribute("classMap").toString());
		System.out.println("dddddddd"+request.getAttribute("testIp"));
		System.out.println(classMap.toString() +"()()()()()(");
		
		/////////
		
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
		model.addAttribute("map", classMap);
		return url;

	}
	
	 
	
	@RequestMapping(value="/serverHandling" ,method = RequestMethod.POST)
	public String handling(HttpServletRequest request, HttpServletResponse response
								, Model model, HttpSession session){
		String url = "redirect:/server/serverMain";
		String adminUser = (String) session.getAttribute("loginUser");
		MemberVO memberVO = null;
		ServerVO serverVO = new ServerVO();
			/*System.out.println(request.getParameter("currentip"));*/
		String  currentip = request.getParameter("currentip");
		Map<String,String> valueMap = classMap.get(currentip);
		valueMap.put("saveyn", "1");
		try {
			memberVO = memberService.selectMember(adminUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(!(memberVO.getMem_group_lice().equals("1"))){
			serverVO.setServer_ip(currentip);
			serverVO.setServer_host(valueMap.get("hostName"));
			serverVO.setServer_os("widow7");
			serverVO.setSaveyn(memberVO.getMem_group_lice());
			serverVO.setServer_id(adminUser);
			
		}else if(memberVO.getMem_group_lice().equals("1")){
			//이부분에서 라이센스변경 후 서버테이블에 추가 
				
			
		}
		// Db쪽에 인설트 순서는 
		// adminUser의 라이센스가 있는지 확인
		// 있다면 currentip 서버에 해당 라이선스 키를 입력함
		// 없다면 새로 라이선스키를 받아(그룹생성) adminUser의 라이센스 변경후 currentip 서버에 해당 라이선스 키를 입력함
				
			
		
			System.out.println("serverHandling");
			System.out.println(classMap.toString());
			
			
			
			
			
			
			//1차적으로 그룹생성/ ====> 서버테이블 등록 >>> 스위치 1
			
			
			/*if(스위치 == 1){
				insert
			}else if(==0){
				
			}
			
			*/
			
			
			
			
			
			
		return url;
	}
	
	
	
	 
}






