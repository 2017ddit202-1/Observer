package com.ddit.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddit.dto.CpuVO;
import com.ddit.service.CpuServiceImpl;


@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private CpuServiceImpl cpuService;
	public void setCpuService (CpuServiceImpl cpuService){
		this.cpuService = cpuService;
	}
	
	@RequestMapping(value="/testForm",method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<CpuVO > cpuList(Model model){
		
		ArrayList<CpuVO> cpuVO = null;
		try {
			cpuVO = cpuService.listCpu();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cpuVO;
	}
		
	@RequestMapping(value="/testFormm",method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<CpuVO> cpuListHo(){
		
		ArrayList<CpuVO> cpuVO = null;
		try {
			cpuVO = cpuService.listCpuHo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cpuVO;
	}
}