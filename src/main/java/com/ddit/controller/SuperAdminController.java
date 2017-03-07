package com.ddit.controller;


import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.ServletContextResource;

import com.ddit.dto.CpuVO;
import com.ddit.dto.DiskVO;
import com.ddit.dto.MemberVO;
import com.ddit.dto.PositionListVO;
import com.ddit.dto.VWmemPosVO;
import com.ddit.dto.VwMemPosSerVO;
import com.ddit.dto.Vw_AuthorityVO;
import com.ddit.service.AlertServiceImpl;
import com.ddit.service.AuthorityServiceImpl;
import com.ddit.service.MemberServiceImpl;
import com.ddit.service.ReportServiceImpl;
import com.ddit.service.SuperAdminServiceImpl;

@Controller
@RequestMapping("/superAdmin")
public class SuperAdminController {
	
	
	@Inject
	WebApplicationContext context;
	
	@Autowired
	private AuthorityServiceImpl authorityService;

	public void setAuthorityService(AuthorityServiceImpl authorityService) {
		this.authorityService = authorityService;
	}
	
	@Autowired
	private MemberServiceImpl memberService;

	public void setMemberService(MemberServiceImpl memberService) {
		this.memberService = memberService;
	}

	@Autowired
	private AlertServiceImpl alertService;
	
	public void setAlertService(AlertServiceImpl alertService) {
		this.alertService = alertService;
	}
	
	@Autowired
	private ReportServiceImpl reportService;
	public void setReportService(ReportServiceImpl reportService){
		this.reportService = reportService;
	}
	
	@Resource(name = "mailSender")
	private MailSender mailSender;
	
	public void setMailSender(MailSender mailSender){
		this.mailSender = mailSender;
	}
	
	@Autowired
	private SuperAdminServiceImpl superAdminService;
	
	public void setSuperAdminService(SuperAdminServiceImpl superAdminService) {
		this.superAdminService = superAdminService;
	}
	
	// 관리페이지
	@RequestMapping("/management")
	public String management(Model model) {
		String url = "/superAdmin/management";
		
		int memberCnt=0;
		int authorityCnt=0;
		
		try {
			memberCnt = memberService.memberCnt();
			authorityCnt = memberService.authorityCnt();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("memberCnt",memberCnt-1);
		model.addAttribute("authorityCnt",authorityCnt);

		return url;
	}

	// 권한요청목록
	@RequestMapping("/authorityList")
	public String authorityList(HttpServletRequest request) {
		String url = "/superAdmin/authorityList";

		ArrayList<Vw_AuthorityVO> su_authorityList = null;

		try {
			su_authorityList = authorityService.authorityList();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("su_authorityList", su_authorityList);

		return url;
	}
	
	//권한 거절
	@RequestMapping(value="/authorityAcceptNO", method = RequestMethod.POST)
	public String authorityAcceptNO(HttpServletRequest request){
		
		String url = "redirect:/superAdmin/authorityList";
		
		String[] chkbox = request.getParameterValues("mem_id");
		for(int i=0; i< chkbox.length; i++){
			try {
				authorityService.authorityRejection(chkbox[i]);//alert테이블에 '거절' 저장
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		return url;
	}
	

	/*보고서보내기 위한 adminList */
	@RequestMapping(value="/reportList")
	public String reportList(Model model){
		String url = "/superAdmin/reportList";
		
		ArrayList<VwMemPosSerVO> plList = null;
		try {
			plList = reportService.adminList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("plList",plList);
		return url;
	}

	@RequestMapping(value="/authorityMemberList", method = RequestMethod.GET)
	public String authorityListUpdate(HttpServletRequest request){
		
		String url = "superAdmin/memberList";
		
		String key = "";
		String tpage = request.getParameter("tpage");

		if (request.getParameter("key") != null) {
			key = request.getParameter("key");
		}
		System.out.println("key@@@@@@: "+key);
		if (tpage == null) {
			tpage = "1";
		} else if (tpage.equals("")) {
			tpage = "1";
		}
		
		request.setAttribute("key", key);
	    request.setAttribute("tpage",tpage);
		
		ArrayList<VWmemPosVO> memberList = null;
		String paging=null;
		
		try {
			memberList= superAdminService.VWmemSerchId(Integer.parseInt(tpage), key);
			paging = superAdminService.pageNumberId(Integer.parseInt(tpage), key);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
             int memberCnt=0;
             int enabledCnt=0;
             int userCnt=0;
             int adminCnt=0;
		
			try {
				memberCnt = memberService.memberCnt();
				enabledCnt = memberService.enabledCnt();
				userCnt = memberService.userCnt();
				adminCnt = memberService.adminCnt();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		/*try {
			memberList = memberDAO.listMember(Integer.parseInt(tpage),key);
			paging = memberDAO.pageNumber(Integer.parseInt(tpage), key);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/

		request.setAttribute("memberList", memberList);
		int n=memberList.size();   
	    request.setAttribute("memberListSize",n); 
	    request.setAttribute("paging", paging); 
	    request.setAttribute("memberCnt", memberCnt-1);
	    request.setAttribute("enabledCnt", enabledCnt);
	    request.setAttribute("userCnt", userCnt);
	    request.setAttribute("adminCnt", adminCnt);
		
		return url;
	}
	
	@RequestMapping(value="/adminUpdatemember", method = RequestMethod.POST)
	public String adminUpdatemember(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		
		String url = "redirect:/superAdmin/authorityMemberList";
	
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String strenabled = request.getParameter("editUseyn");
		String strposition = request.getParameter("editPosition");
		int enabled = 1;
		String position="유저";
		
		System.out.println(strenabled);
		System.out.println(strposition);
		if(strenabled.equals("y")){
			enabled = 1;
		}else{
			enabled = 0;
		}
		
		/*if(strposition.equals("유저")){
			position = "ROLE_USER";
		}else{
			position = "ROLE_ADMIN";
		}*/
		
		MemberVO memberVO = new MemberVO();
		PositionListVO posiotionVO = new PositionListVO();
		memberVO.setMem_id(request.getParameter("editId").trim());
		memberVO.setMem_email(request.getParameter("editEmail"));
		memberVO.setMem_pwd(request.getParameter("editPwd"));
		memberVO.setMem_nm(request.getParameter("editName"));
		memberVO.setMem_phone(request.getParameter("editPhone"));		
		memberVO.setEnabled(enabled);
		memberVO.setMem_group_lice(request.getParameter("editlice"));
		
		posiotionVO.setPosl_id(request.getParameter("editId").trim());
		posiotionVO.setPosl_pos(request.getParameter("editPosition"));
		
		try {
			superAdminService.authorityUpdateMember(memberVO);
			memberService.updatePositionList(posiotionVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return url;
	}
	
	@RequestMapping(value="reportGo",method = RequestMethod.POST , produces="application/json;charset=utf8")
	@ResponseBody
	public String reportEmail(@RequestBody Map<String,Object> reportMap ,HttpServletRequest request,Model model){
		
		String toEmail = null;
		VwMemPosSerVO vwMpsVO = null;
		String resultEmail = null;
		ArrayList<VwMemPosSerVO> ipList = null;
		ArrayList<CpuVO> cpuXls = null;
		ArrayList<DiskVO> driver = null;
		String email = (String) reportMap.get("email");
		String ip = (String) reportMap.get("ip");
		Date date = new Date();
		SimpleDateFormat format = null;
		format = new SimpleDateFormat("yyMMddHHmm");
		
		
		JavaMailSender jmailSender = (JavaMailSender) mailSender;
		MimeMessage message = ((JavaMailSender) mailSender).createMimeMessage();
		
		String content = "<strong>안녕하세요.<br/>"
						+ "서버 관리자님</strong><br/>"
						+"<strong>주간 보고서 입니다.<br/>"
						+ "문의사항이 있으실 경우에는 Q & A 게시판을 이용하여 남겨주시면 신속하고 정확한 답변 해드리겠습니다.<br/><br/>"
						+ "항상 Observer를 이용해주셔서 감사합니다.</strong>";
		
		try {
			// Mail 전송
			driver = reportService.driverList(ip);
			vwMpsVO = reportService.adminMail(email);
			HSSFWorkbook book = reportService.CpuXls(ip);
			String name = format.format(date)+"("+ip+")"+".xls";
			// 경로설정
			ServletContextResource resource = new ServletContextResource(context.getServletContext(),"/WEB-INF/files/"+name);
			File newFile = resource.getFile();
			// 엑셀파일 만들기
			if(newFile.createNewFile()){
				book.write(newFile);
			}
			Thread.sleep(3000);
			
			if(vwMpsVO.getMem_email() != null){
				toEmail = vwMpsVO.getMem_email();
				resultEmail = vwMpsVO.getMem_email()+" 로 전송 되었습니다.";
			}else{
				resultEmail = vwMpsVO.getMem_email()+" 로 전송실패 되었습니다.";
			}
			if(toEmail != null){
				MimeMessageHelper helper = new MimeMessageHelper(message, true,"UTF-8");
				helper.setSubject("[ 주간 보고서 안내 ]");
				helper.setText(content,true);
				helper.setTo(new InternetAddress(toEmail));
				helper.setFrom("observerddit202@gmail.com", "Observer");
				helper.addAttachment(resource.getFilename(), resource);
				jmailSender.send(message);
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultEmail;
	}
	
	@RequestMapping(value="reportListt")
	public String reList(){
		String url = "redirect:/superAdmin/reportList";
		return url;
	}
}
