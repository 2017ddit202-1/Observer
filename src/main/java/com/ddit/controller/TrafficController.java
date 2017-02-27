package com.ddit.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddit.dto.TrafficVO;
import com.ddit.service.TrafficServiceImpl;

@Controller
@RequestMapping("traffic")
public class TrafficController {

	@Autowired
	private TrafficServiceImpl trafficService;
	public void setTrafficService(TrafficServiceImpl trafficService){
		this.trafficService = trafficService;
	}
	
	@RequestMapping("trafficMain")
	public String trafficMain(HttpSession session){
		String url = "traffic/traffic";
		String ip = (String) session.getAttribute("ip");
		
		return url;
	}
	
	@RequestMapping(value="/trafficList",method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<TrafficVO> memoryList(Model model , HttpSession session){
		String ip = (String) session.getAttribute("ip");
		ArrayList<TrafficVO> traList = null;
		String trafficNet = null;
		try {
			traList = trafficService.listTra(ip);
			trafficNet = traList.get(0).getTraffic_net();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return traList;
	}
	@RequestMapping(value="/trafficListHours",method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<TrafficVO> memoryListHours(Model model,HttpSession session){
		ArrayList<TrafficVO> trafficListHo = null;
		String ip = (String) session.getAttribute("ip");
		try {
			trafficListHo = trafficService.listTraHo(ip);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trafficListHo;
	}
	
}
