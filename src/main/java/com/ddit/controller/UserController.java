package com.ddit.controller;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.security.Provider.Service;
import java.sql.SQLException;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddit.dto.AuthorityVO;
import com.ddit.dto.MemberVO;
import com.ddit.dto.PositionListVO;
import com.ddit.service.AuthorityServiceImpl;
import com.ddit.service.MemberServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private MemberServiceImpl memberService;

	public void setMemberService(MemberServiceImpl memberService) {
		this.memberService = memberService;
	}
	
	@Autowired
	private AuthorityServiceImpl authorityService;

	public void setAuthorityService(AuthorityServiceImpl authorityService) {
		this.authorityService = authorityService;
	}

	@RequestMapping("/mypage")
	public String detail(HttpSession session, HttpServletRequest request) {

		String url = "mypage";

		String mem_id = (String) session.getAttribute("loginUser");

		PositionListVO positionList = new PositionListVO();

		try {
			positionList = memberService.authoritySelect(mem_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("positionList", positionList);
		
		
		String userid=(String)session.getAttribute("loginUser");
		
		AuthorityVO authority= new AuthorityVO();
		try {
			authority=authorityService.authorityYN(userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(authority);
		request.setAttribute("authority", authority);
		
		
		return url;
	}

	// 회원정보 수정
	@RequestMapping(value = "/update", method = RequestMethod.GET, produces = "application/text;charset=utf8")
	public String update1(HttpServletRequest request,
			HttpServletResponse response, HttpSession session, Model model) {

		String url = "update";

		String mem_id = (String) session.getAttribute("loginUser");

		MemberVO vo = null;
		try {
			vo = memberService.selectMember(mem_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("loginUser", vo);

		return url;
	}

	// 회원정보 수정
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/text;charset=utf8")
	public String update(HttpServletRequest request,
			HttpServletResponse response) {

		String url = "update";

		MemberVO memberVO = new MemberVO();

		memberVO.setMem_id(request.getParameter("mem_id").trim());
		memberVO.setMem_pwd(request.getParameter("mem_pwd").trim());
		memberVO.setMem_nm(request.getParameter("mem_nm").trim());
		memberVO.setMem_email(request.getParameter("mem_email").trim());
		memberVO.setMem_phone(request.getParameter("mem_phone").trim());

		try {
			memberService.updateMember(memberVO);// 수정한 값을 가져와 업데이트 -> 성공하면
													// alert창

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("loginUser", memberVO);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("<script>  swal('Good job!', '회원수정이 완료되었습니다!', 'success') </script>");

		return url;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String mem_id,
			@RequestParam String mem_pwd, Model model, HttpServletRequest req,
			HttpSession session) {

		String url = "mypage";
		System.out.println("123123123123123");
		MemberVO vo = null;
		try {
			vo = memberService.selectMember(mem_id);
			System.out.println(mem_id + "*controller*");
			System.out.println(mem_pwd + "*controller*");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (vo != null) {
			if (vo.getMem_pwd().equals(mem_pwd)) {
				session.setAttribute("loginUser", vo);
				System.out.println(vo.getMem_id() + "*controller*");
				System.out.println(vo.getMem_pwd() + "*controller*");
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
		}

		System.out.println(mem_id);

		/* model.addAttribute("loginUser", vo); */
		return url;
	}

	// 회원탈퇴
	@RequestMapping(value = "/memberDelete", method = RequestMethod.POST, produces = "application/text;charset=utf8")
	@ResponseBody     // 아작스에서 데이터를 넘겨받기위해 필요한 어노테이션
	public String memberDelete(HttpServletRequest request,
			HttpServletResponse response) {

		String data = "1"; // 성공시 1, 실패시0
		
		String mem_id = request.getParameter("mem_id");

		MemberVO memberVO = null;

		try {
			memberVO = memberService.confirmID2(mem_id); // 아이디로 VO값 셀렉
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		String mem_pwd = memberVO.getMem_pwd();

		if (mem_pwd.equals(request.getParameter("mem_pwd"))) { // 패스워드가 일치하면
			try {
				memberService.memberEnabled(mem_id); // Enabled를 0으로 변경하고
				return data; // 성공값 리턴
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			data = "0";
			return data;
		}

		return data;
	}



}
