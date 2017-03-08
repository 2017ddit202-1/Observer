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

	// 라이선스가 1인 리스트만 보여주는 회원 등록하는 리스트 보여줌
	@RequestMapping("/meminvalid")
	public String groupList(HttpSession session, HttpServletRequest request) {
		String url = "group/groupInvalid";
		
		String key = "";
		String tpage = request.getParameter("tpage");

		if (tpage == null) {
			tpage = "1";
		} else if (tpage.equals("")) {
			tpage = "1";
		}

		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		String paging = null;

		try {
			list = memberService.groupmember(Integer.parseInt(tpage), "1");
			paging = memberService.pageNumberlice(Integer.parseInt(tpage), "1");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("LiceList", list);
		int n = list.size();
		request.setAttribute("memberListSize", n);
		request.setAttribute("paging", paging);
		
		return url;
	}

	// 회원관리 리스트 보여줌
	@RequestMapping("/groupList")
	public String groupmemList(HttpSession session, HttpServletRequest request) {
		String url = "group/groupList";
		String adminid = (String) session.getAttribute("loginUser");
		String Lice = null;
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();

		String key = "";
		String tpage = request.getParameter("tpage");

		if (tpage == null) {
			tpage = "1";
		} else if (tpage.equals("")) {
			tpage = "1";
		}

		MemberVO adminVO = new MemberVO();
		try {
			adminVO = memberService.selectMember(adminid);
			Lice = adminVO.getMem_group_lice();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String paging = null;
		String loginUser = (String) session.getAttribute("loginUser");
		MemberVO mem = new MemberVO();
		mem.setMem_group_lice(Lice);
		mem.setMem_id(loginUser);
		if (Lice != null) {
			try {

				memberList = memberService.groupmemberlist(
						Integer.parseInt(tpage), mem);
				paging = memberService.pageNumbergrlice(
						Integer.parseInt(tpage), mem);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		request.setAttribute("groupList", memberList);
		int n = memberList.size();
		request.setAttribute("memberListSize", n);
		request.setAttribute("paging", paging);
		return url;
	}

	// 그룹에서 회원 해제
	@RequestMapping(value = "/memDelete", method = RequestMethod.POST)
	public String memDelete(HttpSession session, HttpServletRequest request) {
		String url = "group/groupList";
		String adminid = (String) session.getAttribute("loginUser");
		String meminvalid = request.getParameter("member");
		ArrayList<String> invalidList = new ArrayList<String>();
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		StringTokenizer st = new StringTokenizer(meminvalid, ",");
		MemberVO adminVO = new MemberVO();
		MemberVO invalidVO = new MemberVO();
		String Lice = null;
		String groupOk="그룹해제에 실패 했습니다.";
		
		String key = "";
		String tpage = request.getParameter("tpage");

		if (tpage == null) {
			tpage = "1";
		} else if (tpage.equals("")) {
			tpage = "1";
		}
		
		while (st.hasMoreTokens()) {
			invalidList.add(st.nextToken());
		}

		try {
			adminVO = memberService.selectMember(adminid);
			Lice = adminVO.getMem_group_lice();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (Lice != null) {
			for (String member : invalidList) {
				invalidVO.setMem_id(member);
				invalidVO.setMem_group_lice("1");
				try {
					memberService.updateLice(invalidVO);
					groupOk = "그룹해제에 성공 했습니다.";
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		String paging = null;
		String loginUser = (String) session.getAttribute("loginUser");
		MemberVO mem = new MemberVO();
		mem.setMem_group_lice(Lice);
		mem.setMem_id(loginUser);
		
		if (Lice != null) {
			try {
				memberList = memberService.groupmemberlist(
						Integer.parseInt(tpage), mem);
				paging = memberService.pageNumbergrlice(
						Integer.parseInt(tpage), mem);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		request.setAttribute("groupList", memberList);
		int n = memberList.size();
		request.setAttribute("memberListSize", n);
		request.setAttribute("paging", paging);
		request.setAttribute("groupOk", groupOk);
		
		return url;
	}

	// 그룹에서 회원 등록
	@RequestMapping(value = "/memList", method = RequestMethod.POST)
	public String groupInvalid(HttpSession session, HttpServletRequest request) {
		String url = "group/groupList";
		String adminid = (String) session.getAttribute("loginUser");
		String meminvalid = request.getParameter("member");
		ArrayList<String> invalidList = new ArrayList<String>();
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		StringTokenizer st = new StringTokenizer(meminvalid, ",");
		MemberVO adminVO = new MemberVO();
		MemberVO invalidVO = new MemberVO();
		String Lice = null;
		String groupOk="그룹등록에 실패 했습니다.";

		String key = "";
		String tpage = request.getParameter("tpage");

		if (tpage == null) {
			tpage = "1";
		} else if (tpage.equals("")) {
			tpage = "1";
		}

		while (st.hasMoreTokens()) {
			invalidList.add(st.nextToken());
		}

		try {
			adminVO = memberService.selectMember(adminid);
			Lice = adminVO.getMem_group_lice();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (Lice != null) {
			for (String member : invalidList) {
				invalidVO.setMem_id(member);
				invalidVO.setMem_group_lice(Lice);
				try {
					memberService.updateLice(invalidVO);
					groupOk = "그룹등록에 성공 했습니다.";
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		String paging = null;
		String loginUser = (String) session.getAttribute("loginUser");
		MemberVO mem = new MemberVO();
		mem.setMem_group_lice(Lice);
		mem.setMem_id(loginUser);
		
		if (Lice != null) {
			try {
				memberList = memberService.groupmemberlist(
						Integer.parseInt(tpage), mem);
				paging = memberService.pageNumbergrlice(
						Integer.parseInt(tpage), mem);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		request.setAttribute("groupList", memberList);
		int n = memberList.size();
		request.setAttribute("memberListSize", n);
		request.setAttribute("paging", paging);
		request.setAttribute("groupOk", groupOk);
		return url;
	}

}
