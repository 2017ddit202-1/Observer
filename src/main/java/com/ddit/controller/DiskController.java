package com.ddit.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddit.dto.DiskVO;
import com.ddit.service.DiskServiceImpl;

@Controller
@RequestMapping("disk")
public class DiskController {

	@Autowired
	private DiskServiceImpl diskService;
	public void setDiskService(DiskServiceImpl diskService){
		this.diskService = diskService;
	}
	
	@RequestMapping("/diskMain")
	public String diskMain(HttpSession session,Model model){
		String url = "disk/disk";
		String ip = (String) session.getAttribute("ip");
		List<DiskVO> nmList = null;
		
		try {
			nmList = diskService.driverList(ip);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("nmList",nmList);
		
		return url;
	}
	
	@RequestMapping(value="/diskList", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<DiskVO> diskList(@RequestBody Map<String,Object> driMap,HttpSession session,Model model){
		String ip = (String) session.getAttribute("ip");
		String dri = (String) driMap.get("aa");
		List<DiskVO> list = null;
		String cDri = null;
		DiskVO diskVO = new DiskVO();
		StringTokenizer stk = new StringTokenizer(dri,",");
		while(stk.hasMoreElements()){
			cDri = stk.nextToken();
			if(cDri.contains("C:")){
				diskVO.setDisk_ip(ip);
				diskVO.setDisk_nm(cDri);
		}
		}	
		
		try {
			list = (List<DiskVO>) diskService.diskList(diskVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value="/diskListHo",method=RequestMethod.POST , produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<DiskVO> diskListHo(@RequestBody Map<String,Object> driMap , HttpSession session, Model model){
		String ip = (String) session.getAttribute("ip");
		String dri = (String) driMap.get("aa");
		List<DiskVO> list = null;
		String cDri = null;
		DiskVO diskVO = new DiskVO();
		StringTokenizer stk = new StringTokenizer(dri,",");
		while(stk.hasMoreElements()){
			cDri = stk.nextToken();
			if(cDri.contains("C:")){
				diskVO.setDisk_ip(ip);
				diskVO.setDisk_nm(cDri);
		}
		}
		try {
			list = (List<DiskVO>) diskService.diskListHo(diskVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value="/driCBtnList",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<DiskVO> driBtnList(HttpSession session, @RequestBody Map<String,Object> driMap){
		String ip = (String) session.getAttribute("ip");
		String nm = (String) driMap.get("aa");
		List<DiskVO> list = null;
		String cDri = null;
		DiskVO diskVO = new DiskVO();
		if(nm != null){
			diskVO.setDisk_ip(ip);
			diskVO.setDisk_nm(nm);
			try {
				list = diskService.diskList(diskVO);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}
}


