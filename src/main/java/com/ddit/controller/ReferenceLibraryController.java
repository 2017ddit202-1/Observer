package com.ddit.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ddit.dto.Notice_ArticleVO;
import com.ddit.dto.ReferenceLibrayVO;
import com.ddit.service.ReferenceLibrayService;

@Controller
@RequestMapping("/rf")
public class ReferenceLibraryController {
	
	 private String uploadPath = "resources/upload"; //경로
	
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
		
		model.addAttribute("referenceList",referenceList);
		return url;
	}
	@RequestMapping("/referenceWrite")
	public String referenceWrite(){
		String url = "reference/referenceWrite";
		return url;
	}
	
	@RequestMapping(value="/referenceFileUpload", method = RequestMethod.POST)
	public String referenceFileUpload(@RequestParam("uploadfile") MultipartFile multipartFile,
	         HttpServletRequest request,
	         HttpServletResponse response,
	         Model model) throws IllegalStateException, IOException{
		
		String url = "";
		
	
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
		
		
		
		
		String name=multipartFile.getOriginalFilename();//파일이름
		Long size = multipartFile.getSize();//파일사이즈
		
		 String reli_stored =System.currentTimeMillis()+"$$"
	               + multipartFile.getOriginalFilename(); //가공파일이름
		 
		 String upload = request.getSession().getServletContext()
	               .getRealPath(uploadPath);
		
		 File file = new File(upload, reli_stored);
		 

		
		ReferenceLibrayVO referenceVO = new ReferenceLibrayVO();
		referenceVO.setMem_id(request.getParameter("mem_id"));
		referenceVO.setReli_subject(request.getParameter("reli_subject"));
		referenceVO.setReli_content(request.getParameter("reli_content"));
		referenceVO.setReli_file_nm(name);
		referenceVO.setReli_stored_filenm(reli_stored);
		referenceVO.setReli_size(size);
		System.out.println(referenceVO);
		
		try {
			referenceService.insertReference(referenceVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			multipartFile.transferTo(file);
	

		
		return url;
	}
	


}


