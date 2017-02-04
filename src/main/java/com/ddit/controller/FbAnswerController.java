package com.ddit.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddit.dto.FbanswerVO;
import com.ddit.service.FbanswerServiceImpl;

@Controller
@RequestMapping("/fbAns")
public class FbAnswerController {

	@Autowired
	private FbanswerServiceImpl fbanswerService;
	public void setFbanswerService(FbanswerServiceImpl fbanswerService){
		this.fbanswerService = fbanswerService;
	}
	
//	@RequestMapping("/fbAnsWriteForm")
//	public String fbAnsWriteForm(HttpSession session , HttpServletRequest request , Model model){
//		String url = "/fbAnsWriteForm";
//		String id = (String) session.getAttribute("loginUser");
//		String fb_seq = request.getParameter("fb_seq");
//		
//		model.addAttribute("fb_seq",fb_seq);
//		return url;
//	}
	
	@RequestMapping(value="/fbAnsList",method=RequestMethod.POST,produces="application/json;charset=utf8")
	@ResponseBody 
	public List<FbanswerVO> fbAnsList(@RequestBody Map<String,Object> fbMap , Model model){
		List<FbanswerVO> fbAnsList = new ArrayList<FbanswerVO>();
		String fb_fbseq = (String) fbMap.get("fb_fbseq");
		try {
			fbAnsList = fbanswerService.listAllFbAnswer(Integer.parseInt(fb_fbseq));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		return fbAnsList;
	}
	
	@RequestMapping(value ="/fbAnsWrite" , method=RequestMethod.POST,produces="application/json;charset=utf8")
	@ResponseBody
	public List<FbanswerVO> fbAnsWrite(@RequestBody Map<String,Object> fbMap , FbanswerVO fbAnsVO, HttpSession session , HttpServletRequest  request){

		String userId = (String) session.getAttribute("loginUser");
		String fbAns_content = (String) fbMap.get("fbAns_content");
		String fbAns_fbseq = (String) fbMap.get("fb_fbseq");
		
		List<FbanswerVO> fbList = new ArrayList<FbanswerVO>();
		
		fbAnsVO.setFbans_id(userId);
		fbAnsVO.setFbans_fbseq(Integer.parseInt(fbAns_fbseq));
		fbAnsVO.setFbans_content(fbAns_content);
		
		try {
			fbanswerService.insertFbanswer(fbAnsVO);
			fbList = fbanswerService.listAllFbAnswer(fbAnsVO.getFbans_fbseq());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fbList;
	}
	
	@RequestMapping("/fbAnsDelete")
	@ResponseBody
	public Map<String,Object> fbAnsDelete(Model model,HttpServletRequest request){
		int fbAns_seq = Integer.parseInt(request.getParameter("result"));
		Map<String,Object> fbMap = new HashMap();
		
		List<FbanswerVO> fbAnsList = null;
		try {
			fbanswerService.deleteFbanswer(fbAns_seq);
			fbAnsList = fbanswerService.listAllFbAnswer(fbAns_seq);
			fbMap.put("fbAnsList", fbAnsList);
			fbMap.put("fbAns_seq", fbAns_seq);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("fbAns_seq",fbAns_seq);
		
		return fbMap;
	}
}
