package com.ddit.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddit.dto.CpuVO;
import com.ddit.service.CpuServiceImpl;


/**
 * <pre>
 * 
 * </pre>
 * @author 임종구
 * @since 2017. 2. 21.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2017. 2. 21.      pc20       최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/cpu")
public class CpuController {

	@Autowired
	private CpuServiceImpl cpuService;
	public void setCpuService (CpuServiceImpl cpuService){
		this.cpuService = cpuService;
	}
	
	@RequestMapping("cpuMain")
	public String cpuMain(HttpServletRequest request,HttpSession session){
		String url = "cpu/cpu";
		
		String ip = (String) session.getAttribute("ip");
		return url;
	}
	
	@RequestMapping(value="/cpuList",method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<CpuVO > cpuList(Model model,HttpSession session){
		String ip = (String) session.getAttribute("ip");
		ArrayList<CpuVO> cpuVO = null;
		try {
			cpuVO = cpuService.listCpu(ip);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cpuVO;
	}
	
	@RequestMapping(value="/cpuListHours",method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<CpuVO> cpuListHo(HttpSession session){
		String ip = (String) session.getAttribute("ip");
		
		ArrayList<CpuVO> cpuVO = null;
		try {
			cpuVO = cpuService.listCpuHo(ip);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cpuVO;
	}
}