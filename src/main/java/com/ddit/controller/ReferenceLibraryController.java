package com.ddit.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ddit.dto.Notice_ArticleVO;
import com.ddit.dto.ReferenceLibrayVO;
import com.ddit.service.ReferenceLibrayService;

@Controller
@RequestMapping("/rf")
public class ReferenceLibraryController {
	
	@Autowired
	ReferenceLibrayService referenceService;
	
	@RequestMapping("/rfList")
	public String rfList(Model model){
		
		String url="reference/rfList";
		ArrayList<ReferenceLibrayVO> referenceList = null;
		try {
			referenceList=referenceService.listAllReference();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(referenceList+"!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		model.addAttribute("referenceList",referenceList);
		return url;
	}
	@RequestMapping("/referenceWrite")
	public String referenceWrite(){
		String url = "reference/referenceWrite";
		return url;
	}
	


}


