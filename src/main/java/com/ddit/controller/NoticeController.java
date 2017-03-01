package com.ddit.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ddit.dto.MemberGroupVO;
import com.ddit.dto.MemberVO;
import com.ddit.dto.NoticeVO;
import com.ddit.dto.ServerVO;
import com.ddit.service.MemberGroupServiceImpl;
import com.ddit.service.MemberServiceImpl;
import com.ddit.service.NoticeServiceImpl;
import com.ddit.service.ServerServiceImpl;

@Controller
@RequestMapping("notice")
public class NoticeController {

	@Autowired
	private NoticeServiceImpl noticeService;
	public void setNoticeService(NoticeServiceImpl noticeService){
		this.noticeService = noticeService;
	}
	@Autowired
	private ServerServiceImpl serverService;
	public void setServerService(ServerServiceImpl serverService){
		this.serverService = serverService;
	}
	@Autowired
	private MemberServiceImpl memberService;
	public void setMemberService(MemberServiceImpl memberService){
		this.memberService = memberService;
	}
	@Autowired
	private MemberGroupServiceImpl memberGroupService;
	public void setMemberroupService(MemberGroupServiceImpl memberGroupService){
		this.memberGroupService = memberGroupService;
	}
	
	
	@RequestMapping("noticeList")
	public String noticeList(HttpSession session,Model model){
		String url = "notice/notice";
		String code = "";
		String id = (String) session.getAttribute("loginUser");
		String lice = null;
		String memberGroup = null;
		
		MemberVO memberVO = new MemberVO();
		MemberGroupVO memberGroupVO = new MemberGroupVO();
		ServerVO serverVO = new ServerVO();
		List<NoticeVO> noticeList = null;
		NoticeVO noticeVO = null;
		try {
			memberVO = memberService.selectMember(id);
			lice = memberVO.getMem_group_lice();
			if(!(lice.equals("1"))){
				noticeList = noticeService.listAllNotice(lice);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("noticeList",noticeList);
		return url;
	}
	
}
