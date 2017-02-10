package com.ddit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
