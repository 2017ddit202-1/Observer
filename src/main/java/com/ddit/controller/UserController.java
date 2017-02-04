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

import com.ddit.dto.MemberVO;
import com.ddit.service.MemberServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private MemberServiceImpl memberService;
	public void setMemberService(MemberServiceImpl memberService){
		this.memberService = memberService;
	}
	
	
	@RequestMapping("/mypage")
	public String detail() {

		String url = "mypage";
		

		return url;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
	}
	
	//회원정보 수정
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update1(HttpServletRequest request,
			HttpServletResponse response, HttpSession session, Model model){

		String url="update";

		String mem_id=(String)session.getAttribute("loginUser");
		MemberVO vo = null;
		try {
			vo=memberService.selectMember(mem_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("loginUser",vo);
		
		return url;
	}
	
	//회원정보 수정
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(HttpServletRequest request,
	         HttpServletResponse response, HttpSession session){
		
		String url="update";
		
		session = request.getSession();
		MemberVO memberVO = new MemberVO();
		
		System.out.println(request.getParameter("mem_id")+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		memberVO.setMem_id(request.getParameter("mem_id").trim());
		memberVO.setMem_pwd(request.getParameter("mem_pwd").trim());
		memberVO.setMem_nm(request.getParameter("mem_nm").trim());
		memberVO.setMem_email(request.getParameter("mem_email").trim());
		memberVO.setMem_phone(request.getParameter("mem_phone").trim());
		
		try {
			memberService.updateMember(memberVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("loginUser", memberVO);
		
		return url;
	}
	
	@RequestMapping(value="/login" , method = RequestMethod.POST)
	public String login(@RequestParam String mem_id , @RequestParam String mem_pwd ,
			Model model, HttpServletRequest req, HttpSession session){
		
		String url = "mypage";
		System.out.println("123123123123123");
		MemberVO vo = null;
		try {
			vo = memberService.selectMember(mem_id);
			System.out.println(mem_id+"*controller*");
			System.out.println(mem_pwd+"*controller*");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(vo != null){
			if(vo.getMem_pwd().equals(mem_pwd)){
				session.setAttribute("loginUser", vo);
				System.out.println(vo.getMem_id()+"*controller*");
				System.out.println(vo.getMem_pwd()+"*controller*");
				System.out.println("성공");
			}else{
				System.out.println("실패");
			}
		}
		
		System.out.println(mem_id);
		
		/*model.addAttribute("loginUser", vo);*/
		return url;
		}
	
	@RequestMapping(value="/memberDelete", method = RequestMethod.POST, produces = "application/text;charset=utf8")
	public String memberDelete(HttpServletRequest request,HttpServletResponse response){

		
		String url="/index";
		
		String mem_id = request.getParameter("mem_id");

		MemberVO memberVO = null;
		
		try {
			memberVO=memberService.confirmID2(mem_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		String mem_pwd=memberVO.getMem_pwd();
		
		if(mem_pwd.equals(request.getParameter("mem_pwd"))){
			try {
				memberService.memberEnabled(mem_id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
		/*	 PrintWriter out;
			try {
				out = response.getWriter();
				 out.println("<script>alert('비밀번호가 일치하지 않습니다.');</script>"); 
				  out.flush(); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/

	          
		}
	

		
		//아이디로 셀렉을 해서 vo 값을 가져와 입력한 패스워드와 보 값의 패스워드가 같으면
		//ENABLED를 0으로 변경한다
		
	
		
		
		return url;
		
	}
	
	
	
	

	

}
