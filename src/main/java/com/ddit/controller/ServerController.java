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
	Map map = new HashMap();
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
		CloseableHttpResponse httpResponse = null;
		System.out.println("serverController");
		// //
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(
				"http://localhost:8181/observer/server/getServer");
		try {
			httpResponse = httpclient.execute(httpGet);
			System.out.println("httpResponse.getStatusLine(): "
					+ httpResponse.getStatusLine());
			/*
			 * System.out.println(EntityUtils.toString(httpResponse.getEntity()))
			 * ;
			 */

			HttpEntity entity = httpResponse.getEntity();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					httpResponse.getEntity().getContent()));

			String inputLine;
			StringBuffer buffer = new StringBuffer();

			while ((inputLine = reader.readLine()) != null) {
				buffer.append(inputLine);
			}
			reader.close();

			// print result
			System.out.println(response.toString());
			httpclient.close();
			Gson g = new Gson();
			String json = g.toJson(buffer);
			model.addAttribute("json",json);
			
			System.out.println("buffer content : " + buffer.toString());
			model.addAttribute("data", buffer);
		
		
			Map map = new HashMap<String, Object>();
			Gson test = new Gson();
			/*String json = test.toJson(EntityUtils.toString(httpResponse
					.getEntity()));*/
			/*System.out.println(json + "ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");*/
			/*
			 * map =(Map)httpResponse.getEntity();
			 */
			// ////
			/* httpResponse.getEntity().get */

			// ////

			EntityUtils.consume(entity);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				httpResponse.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String loginUser = (String) session.getAttribute("loginUser");
		String userOK = null;
		String column = "";
		// /////
		request = ((ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes()).getRequest();
		String ip = request.getHeader("X-FORWARDED-FOR");
		String host = request.getRemoteHost();

		if (ip == null) {
			ip = request.getRemoteAddr();
		}

		iplist.add(ip);

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

		model.addAttribute("iplist", iplist);
	

		return url;

	}

	@RequestMapping("testForm")
	public String test(HttpServletRequest request, HttpServletResponse response) {
		String url = "server/testGetForm";
		System.out.println("GETFORM()()");
		return url;
	}

	@RequestMapping(value = "getServer", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getServer(
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("GET Server Response");
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("ip", request.getParameter("ip"));
		map.put("hostName", request.getParameter("hostName"));
		/*map.put("flag", "get");
		map.put("success", true);*/  
		return map;

	}

}
