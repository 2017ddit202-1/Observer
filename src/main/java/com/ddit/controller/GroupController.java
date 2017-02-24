package com.ddit.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ddit.dto.MemberVO;
import com.ddit.service.MemberServiceImpl;


@Controller
@RequestMapping("/group")
public class GroupController {

	@Autowired
	private MemberServiceImpl memberService;

	public void setMemberService(MemberServiceImpl memberService) {
		this.memberService = memberService;
	}
	
	//라이선스가 1인 리스트만 보여주는 회원 등록하는 리스트 보여줌
	@RequestMapping("/meminvalid")
	public String groupList(HttpSession session, HttpServletRequest request){
		String url="group/groupInvalid";
		
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		ArrayList<MemberVO> LiceList = new ArrayList<MemberVO>();
		try {
			list= memberService.selectMemberAll(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(list != null){
			for(MemberVO member : list){
				if((member.getMem_id().equals("SUADMIN1"))){
					continue;
				}
				if((member.getMem_group_lice().equals("1"))){
					LiceList.add(member);				}
			}
		}
		
		request.setAttribute("LiceList", LiceList);
		
		return url;
	}
	
	//회원관리 리스트 보여줌
	@RequestMapping("/groupList")
	public String groupmemList(HttpSession session, HttpServletRequest request){
		String url="group/groupList";
		String adminid = (String) session.getAttribute("loginUser");
		String Lice=null;
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		
		MemberVO adminVO = new MemberVO();
		try {
			adminVO = memberService.selectMember(adminid);
			Lice = adminVO.getMem_group_lice();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		if(Lice !=null){
			try {
				memberList = memberService.groupmember(Lice);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		request.setAttribute("groupList", memberList);
		return url;
	}
	
	//그룹에서 회원 해제
	@RequestMapping(value="/memDelete",method=RequestMethod.POST)
	public String memDelete(HttpSession session, HttpServletRequest request){
		String url="group/groupList";
		String adminid = (String) session.getAttribute("loginUser");
		String meminvalid = request.getParameter("member");
		ArrayList<String> invalidList = new ArrayList<String>();
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		StringTokenizer st = new StringTokenizer( meminvalid, "," );
		MemberVO adminVO = new MemberVO();
		MemberVO invalidVO = new MemberVO();
		String Lice=null;
		while( st.hasMoreTokens() ){
			invalidList.add(st.nextToken());
		}
		
		try {
			adminVO = memberService.selectMember(adminid);
			Lice = adminVO.getMem_group_lice();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(Lice !=null){
			for(String member : invalidList){
				invalidVO.setMem_id(member);
				invalidVO.setMem_group_lice("1");
				try {
					memberService.updateLice(invalidVO);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		if(Lice !=null){
			try {
				memberList = memberService.groupmember(Lice);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		request.setAttribute("groupList", memberList);
		return url;
	}
	
	
	//그룹에서 회원 등록
	@RequestMapping(value="/memList",method=RequestMethod.POST)
	public String groupInvalid(HttpSession session, HttpServletRequest request){
		String url="group/groupList";
		String adminid = (String) session.getAttribute("loginUser");
		String meminvalid = request.getParameter("member");
		ArrayList<String> invalidList = new ArrayList<String>();
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		StringTokenizer st = new StringTokenizer( meminvalid, "," );
		MemberVO adminVO = new MemberVO();
		MemberVO invalidVO = new MemberVO();
		String Lice=null;
		while( st.hasMoreTokens() ){
			invalidList.add(st.nextToken());
		}
		
		try {
			adminVO = memberService.selectMember(adminid);
			Lice = adminVO.getMem_group_lice();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(Lice !=null){
			for(String member : invalidList){
				invalidVO.setMem_id(member);
				invalidVO.setMem_group_lice(Lice);
				try {
					memberService.updateLice(invalidVO);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		if(Lice !=null){
			try {
				memberList = memberService.groupmember(Lice);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		request.setAttribute("groupList", memberList);
		
		return url;
	}

}
