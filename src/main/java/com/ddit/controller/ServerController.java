package com.ddit.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddit.dto.CpuVO;
import com.ddit.dto.DataVO;
import com.ddit.dto.DiskVO;
import com.ddit.dto.MemberGroupVO;
import com.ddit.dto.MemberVO;
import com.ddit.dto.MemoryVO;
import com.ddit.dto.NoticeVO;
import com.ddit.dto.ServerInfoVO;
import com.ddit.dto.ServerVO;
import com.ddit.dto.TrafficVO;
import com.ddit.dto.VWmemPosVO;
import com.ddit.service.AlertServiceImpl;
import com.ddit.service.CpuServiceImpl;
import com.ddit.service.DiskServiceImpl;
import com.ddit.service.MemberGroupServiceImpl;
import com.ddit.service.MemberServiceImpl;
import com.ddit.service.MemoryServiceImpl;
import com.ddit.service.NoticeServiceImpl;
import com.ddit.service.ServerServiceImpl;
import com.ddit.service.TrafficServiceImpl;
import com.ddit.service.VWmemPosServiceImpl;

@Controller
@RequestMapping("/server")
public class ServerController {

	static Map<String, Map<String, String>> classMap = new LinkedHashMap<String, Map<String, String>>();

	/*
	 * String classip = "";
	 * 
	 * String classHost = "";
	 */

	@Autowired
	private AlertServiceImpl alertService;

	@Autowired
	private MemberServiceImpl memberService;

	@Autowired
	private ServerServiceImpl serverService;

	@Autowired
	private MemberGroupServiceImpl memberGroupService;

	@Autowired
	private CpuServiceImpl cpuServiceImpl;
	
	@Autowired
	private MemoryServiceImpl memoryServiceImpl;
	
	@Autowired
	private VWmemPosServiceImpl vWmemPosServiceImpl;
	
	@Autowired
	private NoticeServiceImpl noticeServiceImpl;
	
	@Autowired
	private DiskServiceImpl diskServiceImpl;
	public void setDiskServiceImpl(DiskServiceImpl diskServiceImpl){
		this.diskServiceImpl = diskServiceImpl;
	}
	@Autowired
	private TrafficServiceImpl trafficServiceImpl;
	public void setTrafficServiceImpl(TrafficServiceImpl trafficServiceImpl){
		this.trafficServiceImpl = trafficServiceImpl;
	}
	
	
	public void setMemberGroupService(MemberGroupServiceImpl memberGroupService) {
		this.memberGroupService = memberGroupService;
	}

	public void setvWmemPosserviceImpl(VWmemPosServiceImpl vWmemPosServiceImpl) {
		this.vWmemPosServiceImpl = vWmemPosServiceImpl;
	}

	public void setMemoryServiceImpl(MemoryServiceImpl memoryServiceImpl) {
		this.memoryServiceImpl = memoryServiceImpl;
	}

	public void setCpuServiceImpl(CpuServiceImpl cpuServiceImpl) {
		this.cpuServiceImpl = cpuServiceImpl;
	}

	public void setMemberService(MemberServiceImpl memberService) {
		this.memberService = memberService;
	}

	public void setServerService(ServerServiceImpl serverService) {
		this.serverService = serverService;
	}

	public void setAlertService(AlertServiceImpl alertService) {
		this.alertService = alertService;
	}
	
	
	@RequestMapping(value = "/serverMain", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String test(HttpServletRequest request,
			HttpServletResponse response, Model model, HttpSession session) {
		String url = "server/serverMain";
		String currentIp = request.getParameter("testIp");
		String saveyn = null;
		List<String> iplist = new ArrayList<String>();
		classMap = (Map<String, Map<String, String>>) request
				.getAttribute("classMap");
		Map<String, String> valueMap = classMap.get(currentIp);

		// 서버 table에서 currentip 로 셀렉해서 saveyn이 1이면
		
		ServerVO serverVO = new ServerVO();
		try {
			serverVO = serverService.selectServerVO(currentIp);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(serverVO == null){
			serverVO = new ServerVO();
			serverVO.setSaveyn("0"); //0이면 db에 insert를 안함
		}
		valueMap.put("saveyn", serverVO.getSaveyn());
		classMap.put(currentIp, valueMap);

		CpuVO cpuVO = new CpuVO();
		MemoryVO memoryVO = new MemoryVO();
		DiskVO diskVO = new DiskVO();
		TrafficVO trafficVO = new TrafficVO();
			
		
		if (serverVO.getSaveyn().equals("1")) {
		        if(classMap.get(currentIp).get("alertcpu") != null){
		        	cpuNotice(currentIp);
		         }else if(classMap.get(currentIp).get("alertmemory") != null){
		            System.out.println("메모리 과다 알림 : " + classMap.get(currentIp).get("memory_total_used"));
		            memoryNotice(currentIp);
		         }else if(classMap.get(currentIp).get("alertcpu") != null && classMap.get(currentIp).get("alertmemory") != null){
		            System.out.println("메모리 + 시피유 과다 알림 : ");
		            cpu_memory_Notice(currentIp);
		         }
		        
		        
			// cpu 테이블에 인설트
			cpuVO.setCpu_pcnt(classMap.get(currentIp).get("cpu_pcnt"));
			cpuVO.setCpu_user_pcnt(classMap.get(currentIp).get("cpu_user_pcnt"));
			cpuVO.setCpu_total_pcnt(classMap.get(currentIp).get("cpu_total_pcnt"));
			cpuVO.setCpu_idle(classMap.get(currentIp).get("cpu_idle"));
			cpuVO.setCpu_ip(currentIp);
			cpuVO.setServer_code(serverVO.getServer_code());
			
			memoryVO.setMemory_ip(currentIp);
			memoryVO.setMemory_total(classMap.get(currentIp).get("memory_total"));
			memoryVO.setMemory_using(classMap.get(currentIp).get("memory_using"));
			memoryVO.setMemory_idle(classMap.get(currentIp).get("memory_idle"));
			memoryVO.setMemory_total_used(classMap.get(currentIp).get("memory_total_used"));
			memoryVO.setServer_code(serverVO.getServer_code());
			
			String rx = classMap.get(currentIp).get("networkrx");
			String tx = classMap.get(currentIp).get("networktx");
			double rxTt = 0;
			double txTt = 0;
			double txrxTotal=0;
			String total = "";
			int k = 1000;
			if(rx.contains("K")){
				rxTt = Double.parseDouble(rx.replaceAll("K", "").trim())*k;
			}else{
				rxTt = Double.parseDouble(rx);
			}
			
			if(tx.contains("K")){
				txTt = Double.parseDouble(tx.replaceAll("K", "").trim())*k;
			}else{
				txTt = Double.parseDouble(tx);
			}
			
			txrxTotal = rxTt + txTt;
			if(txrxTotal >= 1000){
				total = (txrxTotal/k+"K").trim();
			}else{
				total = (txrxTotal+"").trim();
			}
			trafficVO.setTraffic_ip(currentIp);
			trafficVO.setTraffic_use(total.trim());
			trafficVO.setTraffic_rece(classMap.get(currentIp).get("networkrx"));
			trafficVO.setTraffic_trans(classMap.get(currentIp).get("networktx"));
			trafficVO.setServer_code(serverVO.getServer_code());
			trafficVO.setTraffic_net(classMap.get(currentIp).get("networkcard"));
			
			String diskMap = classMap.get(currentIp).get("diskAll");
			String replaceMap = diskMap.replaceAll("\\[", "");
			String temp = "";
			int count = 0;
			Map<Integer,String> mapList = new HashMap<Integer, String>();
			StringTokenizer token = new StringTokenizer(replaceMap,"]");
			while(token.hasMoreTokens()){
				temp += token.nextToken()+",";
			}
			StringTokenizer token2 = new StringTokenizer(temp,",");
			while(token2.hasMoreTokens()){
				mapList.put(count++, token2.nextToken().trim());
			}
			int size = mapList.size();
			int tsize = size/5;
			int cnt = 0;
			for(int i=0; i<tsize; i++){
				diskVO.setDisk_nm(mapList.get(cnt));
				diskVO.setDisk_total(mapList.get(cnt+1));
				diskVO.setDisk_using(mapList.get(cnt+2));
				diskVO.setDisk_idle(mapList.get(cnt+3));
				diskVO.setDisk_pcnt(mapList.get(cnt+4));
				diskVO.setDisk_ip(currentIp);
				diskVO.setServer_code(serverVO.getServer_code());
				cnt = cnt+5;
				try {
					diskServiceImpl.insertDisk(diskVO);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			try {
				cpuServiceImpl.insertCpu(cpuVO);
				memoryServiceImpl.insertMemory(memoryVO);
				trafficServiceImpl.insertTraffic(trafficVO);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

		// ///////

		String loginUser = (String) session.getAttribute("loginUser");
		String userOK = null;
		String column = "";

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

		session.setAttribute("currentIp", currentIp);
		model.addAttribute("map", classMap);
		
		return url;

	}

	
	///////////@@@@@
	
	@RequestMapping(value = "/serverMain", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String test2(HttpServletRequest request,
			HttpServletResponse response, Model model, HttpSession session) {
		String url = "server/serverMain";
		System.out.println("GET method");
		List<String> iplist = new ArrayList<String>();
		MemberGroupVO memberGroupVO = new MemberGroupVO();
		int summaryMenu = 0;
		classMap = (Map<String, Map<String, String>>) request
				.getAttribute("classMap");
					 String currentIp = (String)session.getAttribute("currentIp");
					 
		// ///////

		String loginUser = (String) session.getAttribute("loginUser");
		String userOK = null;
		String column = "";
		VWmemPosVO vWmemPosVO = new VWmemPosVO();
		List<ServerVO> serverList = new ArrayList<ServerVO>();
		List<ServerVO> serverListUser= new ArrayList<ServerVO>();
		List<String> serverIpList= new ArrayList<String>();
		
		Map<String, Map> serverMap = new HashMap<String, Map>();
		  Map<String, String> ipMap = new HashMap<String, String>();
		try {
			userOK = alertService.select_sessionID(loginUser); // alert테이블에 ID값이
			column = alertService.authority_content(loginUser);
			alertService.alertDelete(loginUser);
			vWmemPosVO = vWmemPosServiceImpl.memposVO(loginUser);
			  memberGroupVO = (MemberGroupVO) memberGroupService.selectMemberGroupVO(vWmemPosVO.getMem_group_lice());
			  if(memberGroupVO != null){
				  if(!(memberGroupVO.getMg_lice().equals("1"))){
					  /*serverListUser = serverService.selectServerList(memberGroupVO.getMem_id());*/
					  serverIpList = (List<String>)serverService.selectServerIpList(memberGroupVO.getMem_id());
					  for(String ip : serverIpList){
						  
						  ServerVO serverVO = new ServerVO();
						  ServerInfoVO serverInfoVO = new ServerInfoVO();
						  Map<String, String> infoMap = new HashMap<String, String>();
						  //IP 를 이용해서 필요한 정보를 SELECT하여 MAP(해당IP/vo)로 넣는다
						  String cpu = cpuServiceImpl.SelectCpuTotalpcnt(ip);
						 serverInfoVO.setMemory_total(memoryServiceImpl.selectMemoryTotal(ip));
						 serverInfoVO.setCpu_total_pcnt(cpuServiceImpl.SelectCpuTotalpcnt(ip));
						 serverVO = serverService.SelectServerInfo(ip);
						 serverInfoVO.setServer_host(serverVO.getServer_host());
						 serverInfoVO.setServer_os_name(serverVO.getServer_os_name());
						 serverInfoVO.setServer_ip(serverVO.getServer_ip());
						 
						 infoMap.put("server_host", serverInfoVO.getServer_host());
						 infoMap.put("server_os_name", serverInfoVO.getServer_os_name());
						 infoMap.put("server_ip", serverInfoVO.getServer_ip());
						 infoMap.put("server_saveyn", serverVO.getSaveyn());
						 infoMap.put("cpu_total_pcnt", serverInfoVO.getCpu_total_pcnt());
						 infoMap.put("memory_total", serverInfoVO.getMemory_total());
						 /*model.addAttribute("cpu_total_pcnt",serverInfoVO.getCpu_total_pcnt());*/
						 ipMap.put(ip, cpu);
						 serverMap.put(ip, infoMap);
					  }
				  }			 
			  }
			serverList = serverService.selectServerList(loginUser);
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
		
		
		HttpSession flag = request.getSession();
		flag.setAttribute("summaryMenu", summaryMenu);
		
		model.addAttribute("serverMap",serverMap);
		model.addAttribute("serverListUser", serverListUser);
		model.addAttribute("serverList", serverList);
		model.addAttribute("loginUserPosl", vWmemPosVO.getPosl_pos());
		model.addAttribute("map", classMap);
		/*model.addAttribute("ipMap", ipMap);*/
		return url;

	}

	
	//@@@@@
	/**
	 * Db쪽에 인설트 순서는 adminUser의 라이센스가 있는지 확인 있다면 currentip 서버에 해당 라이선스 키를 입력함 없다면
	 * 새로 라이선스키를 받아(그룹생성) adminUser의 라이센스 변경후 currentip 서버에 해당 라이선스 키를 입력함
	 */
	static int a = 1;

	@RequestMapping(value = "/serverHandling", method = RequestMethod.POST)
	public String handling(HttpServletRequest request,
			HttpServletResponse response, Model model, HttpSession session) {
		String url = "redirect:/server/serverMain";
		String adminUser = (String) session.getAttribute("loginUser");
		MemberVO memberVO = null;
		ServerVO serverVO = new ServerVO();
		/* System.out.println(request.getParameter("currentip")); */

		String currentIp = request.getParameter("currentIp");
		Map<String, String> valueMap = classMap.get(currentIp);
		valueMap.put("saveyn", "1");
		try {
			memberVO = memberService.selectMember(adminUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!(memberVO.getMem_group_lice().equals("1"))) {

			serverVO.setServer_host(valueMap.get("hostName"));
			serverVO.setServer_os_version(valueMap.get("os_version"));
			serverVO.setServer_ip(currentIp);
			serverVO.setSaveyn("1");
			serverVO.setServer_id(adminUser);
			serverVO.setServer_os_name(valueMap.get("os_name"));
			serverVO.setServer_os_support(valueMap.get("os_support"));

			serverVO.setServer_code("A" + a);
			a++;
			try {
				// 인설트이전에 currentIp로 테이블에 중복확인하여 중복이면 update
				String ip = null;
				ip = serverService.selectServerIP(currentIp);
				if (ip != null) {
					// update
					serverService.updateServer(serverVO);
				} else if (ip == null) {
					serverService.insertServer(serverVO);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*classMap.remove(currentIp);*/
		} else if (memberVO.getMem_group_lice().equals("1")) {
			// 이부분에서 라이센스변경 후 서버테이블에 추가
			int result = (int) (Math.floor(Math.random() * 1000000) + 100000);
			if (result > 1000000) {
				result = result - 100000;
			}
			memberVO.setMem_group_lice(result + "");
			// member테이블에 update하고 , member_group에 insert
			MemberGroupVO memberGroupVO = new MemberGroupVO();
			memberGroupVO.setMem_id(memberVO.getMem_id());
			memberGroupVO.setMg_nm(memberVO.getMem_nm());
			memberGroupVO.setMg_lice(memberVO.getMem_group_lice());

			// serverVO 추가
			serverVO.setServer_host(valueMap.get("hostName"));
			serverVO.setServer_os_version(valueMap.get("os_version"));
			serverVO.setServer_ip(currentIp);
			serverVO.setSaveyn("1");
			serverVO.setServer_id(adminUser);
			serverVO.setServer_os_name(valueMap.get("os_name"));
			serverVO.setServer_os_support(valueMap.get("os_support"));
			serverVO.setServer_code("A" + a);
			a++;
			try {
				// update
				memberGroupService.insertMemberGroupVO(memberGroupVO);
				memberService.updateMember(memberVO);
				// 인설트이전에 currentIp로 테이블에 중복확인하여 중복이면 update
				String ip = null;
				ip = serverService.selectServerIP(currentIp);
				if (ip != null) {
					// update
					serverService.updateServer(serverVO);
				} else if (ip == null) {
					serverService.insertServer(serverVO);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*classMap.remove(currentIp);*/
		}
		session.setAttribute("loginUserVO", memberVO);
		
		
		return url;
	}
	
	@RequestMapping("/summary")
	public String summary(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		String url = "server/summaryInfo";
		session.removeAttribute("summaryMenu");
		session.setAttribute("summaryMenu", request.getParameter("summaryMenu"));
			System.out.println(request.getParameter("summaryMenu"));
		
		String ip = request.getParameter("ip");
		
		if(ip!=null){
			session.setAttribute("ip", ip);
		}		
		return url;
	}
	
	
	/**
	 * stopIp를 이용하여 해당 ip의 savayn을 0으로 바꾸어 정지시킨다. 
	 * saveyn은 전송되어지는 데이터를 DB에 저장할것인지를 정해주는 속성
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("/serverStop")
	public String serverStop(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		String url = "redirect:/server/serverMain";
		ServerVO serverVO = new ServerVO();
		String ipArray = request.getParameter("ipArray");
		
		StringTokenizer ip = new StringTokenizer(ipArray, ",");
		
		try{
			while(ip.hasMoreElements()){
				serverVO = serverService.selectServerVO(ip.nextToken());
				if(serverVO.getSaveyn().equals("1")){
					serverVO.setSaveyn("0");
				}
				serverService.updateServer(serverVO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return url;
	}
	
	
	
	/**
	 * ip를 이용해서 해당 ip의 saveyn을 0에서 1로 update 
	 * saveyn은 전송되어지는 데이터를 DB에 저장할것인지를 정해주는 속성
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("/serverStart")
	public String serverStart(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		String url = "redirect:/server/serverMain";
		ServerVO serverVO = new ServerVO();
		String ipArray = request.getParameter("ipArray");
		StringTokenizer ip = new StringTokenizer(ipArray, ",");
			try{
				while(ip.hasMoreElements()){
					serverVO = serverService.selectServerVO(ip.nextToken());
					if(serverVO.getSaveyn().equals("0")){
						serverVO.setSaveyn("1");
					}
					serverService.updateServer(serverVO);
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
	
		return url;
	}
	
	
	/**
	 * ip를 이용하여 해당 ip의 정보를 db에서 삭제 
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("/serverRemove")
	public String serverRemove(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		String url = "redirect:/server/serverMain";
			ServerVO serverVO = new ServerVO();
			String ipArray = request.getParameter("ipArray");
			StringTokenizer ip = new StringTokenizer(ipArray, ",");
			
			try{
				while(ip.hasMoreElements()){
					serverVO = serverService.selectServerVO(ip.nextToken());
					if(serverVO != null){
						serverService.deleteServerIp(serverVO.getServer_ip());
					}
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		return url;
	}
	
	
	
	
	
//CPU사용량 초과되었을때
	public void cpuNotice(String currentIp){
	      ServerVO serverVO = new ServerVO();
	      String lice="";
	      String code="";
	      String id = null;
	      MemberGroupVO mgRroupVO = null;
	      try {
	    	  code = serverService.selectServercode_Info(currentIp);
	    	  serverVO =  serverService.selectCode(currentIp);
	    	  id = serverVO.getServer_id();
	    	  mgRroupVO = memberGroupService.selectLice(id);
	    	  lice = mgRroupVO.getMg_lice();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      
	      
	      
	      //notice 테이블에 알림내역 insert
	      NoticeVO noticeVO = new NoticeVO();
	        String cpu=classMap.get(currentIp).get("cpu_total_pcnt");
			noticeVO.setNotice_server_nm(classMap.get(currentIp).get("hostName")); 
			noticeVO.setNotice_dng_lv("위험");
			noticeVO.setNotice_content("현재 CPU 사용량은"+cpu+"% 입니다. 80% 초과되었습니다. CPU를 점검하세요");
			noticeVO.setNotice_ip(currentIp);
			noticeVO.setServer_code(code);
			noticeVO.setNotice_lice(lice);
			try {
				noticeServiceImpl.insertNotice(noticeVO);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	//Memory사용량 초과되었을때
	public void memoryNotice(String currentIp){
		  ServerVO serverVO = new ServerVO();
	      MemberVO memberVO = new MemberVO();
	      String id ="";
	      String lice="";
	      try {
	         serverVO = serverService.SelectServerInfo(currentIp);
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      
	      //notice 테이블에 알림내역 insert
	      NoticeVO noticeVO = new NoticeVO();
			
	      
	        String memory=classMap.get(currentIp).get("memory_total");
			noticeVO.setNotice_server_nm(classMap.get(currentIp).get("hostName"));
			noticeVO.setNotice_dng_lv("위험");
			noticeVO.setNotice_content("현재 Memory 사용량은"+memory+"% 입니다. 80% 초과되었습니다. Memory를 점검하세요");
			noticeVO.setNotice_ip(currentIp);
			noticeVO.setServer_code(serverVO.getServer_code());
			
			try {
				noticeServiceImpl.insertNotice(noticeVO);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	//CUP, Memory 사용량 초과되었을때
	public void cpu_memory_Notice(String currentIp){
		  ServerVO serverVO = new ServerVO();
	      MemberVO memberVO = new MemberVO();
	      String id ="";
	      String lice="";
	      try {
	         serverVO = serverService.SelectServerInfo(currentIp);
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      
	      //notice 테이블에 알림내역 insert
	      NoticeVO noticeVO = new NoticeVO();
			
	      
	        String cpu=classMap.get(currentIp).get("cpu_total_pcnt");
	        String memory=classMap.get(currentIp).get("memory_total");
			noticeVO.setNotice_server_nm(classMap.get(currentIp).get("hostName"));
			noticeVO.setNotice_dng_lv("위험");
			noticeVO.setNotice_content("현재 Memory 사용량은"+memory+"% CPU 사용량은"+cpu+"입니다. 80% 초과되었습니다. Memory, CPU를 점검하세요");
			noticeVO.setNotice_ip(currentIp);
			noticeVO.setServer_code(serverVO.getServer_code());
			
			try {
				noticeServiceImpl.insertNotice(noticeVO);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}	
	@RequestMapping(value="/summaryPage", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public Map<Object,Object> summaryPage(HttpSession session){
		String ip = (String) session.getAttribute("ip");
		DataVO cpuVO = new DataVO();
		DataVO memoryVO = new DataVO();
		DataVO diskVO = new DataVO();
		DataVO trafficVO = new DataVO();
		
		DiskVO diVO = new DiskVO();
		List<String> cpuList  = new ArrayList<String>();
		List<String> memoryList  = new ArrayList<String>();
		List<String> diskList  = new ArrayList<String>();
		List<String> trafficList  = new ArrayList<String>();
		List<Date> dateList  = new ArrayList<Date>();
		
		List<CpuVO> cpuVoList = null;
		List<MemoryVO> memoryVoList = null;
		List<DiskVO> diskVoList = null;
		List<TrafficVO> trafficVoList = null;
		List<TrafficVO> dateVoList = null;
		
		List<DiskVO> diVo = null;
		
		try {
			diVo = diskServiceImpl.driverList(ip);
			diVO.setDisk_ip(ip);
			diVO.setDisk_nm(diVo.get(0).getDisk_nm());
			
			cpuVoList = cpuServiceImpl.listCpu(ip);
			memoryVoList = memoryServiceImpl.listMemory(ip);
			trafficVoList = trafficServiceImpl.listTra(ip);
			diskVoList = diskServiceImpl.diskList(diVO);
			
			for (int i = 0; i < cpuVoList.size(); i++) {
				cpuList.add(cpuVoList.get(i).getCpu_pcnt());
				dateList.add(cpuVoList.get(i).getCpu_date());
			}
			for (int i = 0; i < memoryVoList.size(); i++) {
				memoryList.add(memoryVoList.get(i).getMemory_total_used());
			}
			for (int i = 0; i < diskVoList.size(); i++) {
				diskList.add(diskVoList.get(i).getDisk_using());
			}
			for (int i = 0; i < trafficVoList.size(); i++) {
				trafficList.add(trafficVoList.get(i).getTraffic_use());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cpuVO.setData(cpuList);
		cpuVO.setName("CPU 사용량");
		cpuVO.setType("line");
		cpuVO.setValueDecimal(1);
		cpuVO.setUnit("%");
		
		diskVO.setData(diskList);
		diskVO.setName("DISK 사용량");
		diskVO.setType("area");
		diskVO.setValueDecimal(0);
		diskVO.setUnit("%");
		
		memoryVO.setData(memoryList);
		memoryVO.setName("MEMORY 사용량");
		memoryVO.setType("area");
		memoryVO.setValueDecimal(1);
		memoryVO.setUnit("%");
		
		trafficVO.setData(trafficList);
		trafficVO.setName("TRAFFIC 사용량");
		trafficVO.setType("line");
		trafficVO.setValueDecimal(1);
		trafficVO.setUnit("bps");
		
		
		
		Map<Object,Object> map = new HashMap<Object, Object>();
		map.put("datasets", Arrays.asList(cpuVO,diskVO,memoryVO,trafficVO));
		map.put("xData", dateList);
		return map;
	}
	
	@RequestMapping(value="/serverInfo",method = RequestMethod.POST,produces="application/json;charset=UTF-8" )
	@ResponseBody
	public ServerVO summaryServer(HttpSession session){
		String ip = (String) session.getAttribute("ip");
		ServerVO serverVO = null;
		
		try {
			serverVO = serverService.listAllSummary(ip);
			System.out.println("ServerVO"+serverVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return serverVO;
	}

}
