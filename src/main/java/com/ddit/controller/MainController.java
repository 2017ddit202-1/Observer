package com.ddit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddit.dto.MemberVO;
import com.ddit.service.MemberServiceImpl;

@Controller
public class MainController {
	
	@Autowired
	private MemberServiceImpl memberService;
	
	public void setMemberServiceImpl(MemberServiceImpl memberService){
		this.memberService = memberService;
	}
	
	@Resource(name = "mailSender")
	private MailSender mailSender;
	
	public void setMailSender(MailSender mailSender){
		this.mailSender = mailSender;
	}
	
	
	

	@RequestMapping("/")
	public String main() {

		String url = "index";

		return url;
	}
	
	@RequestMapping("/index")
	public String gomain() {

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
		String mem_id = request.getParameter("mem_id");
		
		try {
			memberService.insertMember(memberVO);
			memberService.positionRole(mem_id);
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

	//아이디중복체크
	@RequestMapping("/idCheckForm")
	public String idCheckForm(HttpServletRequest request,
			HttpServletResponse response, Model model)throws ServletException, IOException{
		String url = "idCheckForm";
		String id = request.getParameter("mem_id").trim();
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
	//로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		String url = "redirect:/";
		session.invalidate();
		return url;
	}
	
	@RequestMapping("/idSearch")
	public String idSearch(){
		String url = "idSearch";
		return url;
	}
	// ID찾기 ( 로그인 시 )
	@RequestMapping(value = "/idFind", method = RequestMethod.POST ,produces="application/text;charset=utf8")
	@ResponseBody
	public String idFind(HttpServletRequest request, HttpServletResponse response , HttpSession session , Model model){
		
		String name = request.getParameter("mem_nm");
		String email = request.getParameter("mem_email");
		MemberVO member = null;
		String data = "";
		
		try {
			member = memberService.idFind(name, email);
			if(member != null){
				data = member.getMem_id();
			}else{
				data = "찾는아이디가 없습니다.";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
		
	}
	// Password찾기 및 이메일 전송 ( 로그인 시 )
	@RequestMapping(value = "/pwdFind", method = RequestMethod.POST ,produces="application/text;charset=utf8")
	@ResponseBody
	public String pwdFind(HttpServletRequest request,HttpServletResponse response , HttpSession session , Model model){
		
		JavaMailSender jmailSender = (JavaMailSender) mailSender;
		MimeMessage message = ((JavaMailSender) mailSender).createMimeMessage();
		String content = "<strong>안녕하세요. Observer 회원님</strong><br>"
				+ "<strong>당신의 비밀번호는</strong> ";
		MemberVO member = null;
		MemberVO updateMember = new MemberVO();
		String userid = request.getParameter("mem_id");
		String email = request.getParameter("mem_email");
		
		String resultEmail = null;
		String toEmail = null;
		String toPwd = null;
		
		String tempPwd = "";
		for (int i = 0; i < 8; i++) {
			int rndVal = (int) (Math.random() * 62);
			if (rndVal < 10) {
				tempPwd += rndVal;
			} else if (rndVal > 35) {
				tempPwd += (char) (rndVal + 61);
			} else {
				tempPwd += (char) (rndVal + 55);
			}
		}
		
		try {
			member = memberService.pwdFind(userid, email);
			
			if (member.getMem_email() != null && member.getMem_id() != null) {
				toEmail = member.getMem_email();
				toPwd = tempPwd;
				
				updateMember.setMem_pwd(toPwd);
				updateMember.setMem_id(userid);
				
				memberService.tempPwd(updateMember);
				
				content = content + " [ <strong> " + toPwd + " </strong> ] " +" &nbsp;<strong>입니다</strong>";
				resultEmail = member.getMem_email()+"로 메일이 성공적으로 전송되었습니다.";
			}else{
				resultEmail = "이메일이 맞지 않습니다.";
			}
			
			if (toEmail != null) {
				MimeMessageHelper helper = new MimeMessageHelper(message, true,
						"UTF-8");
				helper.setSubject("[ 비밀번호 찾기 안내 ]");
				helper.setText(content, true);
				helper.setFrom("observerddit202@gmail.com", "Observer");
				helper.setTo(new InternetAddress(toEmail, "utf-8"));

				jmailSender.send(message);
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultEmail;
	}
}





















