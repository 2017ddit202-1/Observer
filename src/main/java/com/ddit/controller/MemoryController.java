package com.ddit.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddit.dto.MemoryVO;
import com.ddit.service.MemoryServiceImpl;

@Controller
@RequestMapping("memory")
public class MemoryController {

	@Autowired
	private MemoryServiceImpl memoryService;
	public void setMemoryService(MemoryServiceImpl memoryService){
		this.memoryService = memoryService;
	}
	
	@RequestMapping("memoryMain")
	public String memoryMian(){
		String url = "memory/memory";
		return url;
	}
	
	@RequestMapping(value="memoryList",method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<MemoryVO> memoryList(Model model){
		
		ArrayList<MemoryVO> memoList = null;
		
		try {
			memoList = memoryService.listMemory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memoList;
	}
	@RequestMapping(value="memoryListHours",method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<MemoryVO> memoryListHours(Model model){
		ArrayList<MemoryVO> memoListHo = null;
		
		try {
			memoListHo = memoryService.listMemoryHo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memoListHo;
	}
	
}
