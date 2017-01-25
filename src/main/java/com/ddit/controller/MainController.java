package com.ddit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ddit.dto.MemberVO;
import com.ddit.service.MemberServiceImpl;

@Controller
public class MainController {
	
	@Autowired
	private MemberServiceImpl memberService;
	
	public void setMemberServiceImpl(MemberServiceImpl memberService){
		this.memberService = memberService;
	}
	

	@RequestMapping("/")
	public String main() {

		String url = "index";

		return url;
	}
	
	@RequestMapping("/loginForm")
	public void login(HttpServletResponse res){
		String html="<script>alert(\"로그인 하세요\");history.go(-1);</script>";
				
		try {
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out=res.getWriter();
			out.println(html);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//회원가입
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String getj() {

		String url = "join";

		return url;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
	}
	
	//회원가입
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String url = "index";
		HttpSession session = request.getSession();
		
		MemberVO memberVO = new MemberVO();
		memberVO.setMem_id(request.getParameter("mem_id"));
		memberVO.setMem_pwd(request.getParameter("mem_pwd"));
		memberVO.setMem_nm(request.getParameter("mem_nm"));
		memberVO.setMem_email(request.getParameter("mem_email"));
		memberVO.setMem_phone(request.getParameter("mem_phone"));
		System.out.println(memberVO);
		try {
			memberService.insertMember(memberVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
	}
	
	@RequestMapping("/detail")
	public String detail() {

		String url = "detail";

		return url;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
	}

	//아이디찾기
	@RequestMapping("/idCheckForm")
	public String idCheckForm(HttpServletRequest request,
			HttpServletResponse response, Model model)throws ServletException, IOException{
		String url = "idCheckForm";
		String id = request.getParameter("mem_id").trim();
		System.out.println(id);
		int result=-1;
		try {
		result=memberService.confirmID(id);
		model.addAttribute("message",result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("mem_id", id);
		
		return url;
	}
}





















