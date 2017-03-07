package com.ddit.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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

/**
 * <pre>
 * 
 * </pre>
 * @author 임종구
 * @since 2017. 3. 6.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2017. 3. 6.      pc20       최초작성
 * Copyright (c) 2017 by DDIT All right reserved
 * </pre>
 */
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
	public String noticeList(HttpSession session,Model model,HttpServletRequest request){
		
		String url = "notice/notice";
		String id = (String) session.getAttribute("loginUser");
		String lice = null;
		String tpage = request.getParameter("tpage");

		if (tpage == null) {
			tpage = "1";
		} else if (tpage.equals("")) {
			tpage = "1";
		}
		
		String paging = null;
		MemberVO memberVO = new MemberVO();
		List<NoticeVO> noticeList = null;
		try {
			memberVO = memberService.selectMember(id);
			lice = memberVO.getMem_group_lice();
			if(!(lice.equals("1"))){
				noticeList = noticeService.Noticelist(Integer.parseInt(tpage), lice);
				paging = noticeService.totalNoticelist(Integer.parseInt(tpage),lice);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
		request.setAttribute("noticeList", noticeList);
		int n = noticeList.size();
		request.setAttribute("memberListSize", n);
		request.setAttribute("paging", paging);
		
		return url;
	
}
}