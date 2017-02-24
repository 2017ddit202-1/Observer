package com.ddit.controller;

import java.io.File;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

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
import com.ddit.dto.VwMemPosSerVO;
import com.ddit.dto.Vw_AuthorityVO;
import com.ddit.service.AlertServiceImpl;
import com.ddit.service.AuthorityServiceImpl;
import com.ddit.service.ReportServiceImpl;

@Controller
@RequestMapping("/superAdmin")
public class SuperAdminController {

	@Autowired
	private AuthorityServiceImpl authorityService;

	public void setAuthorityService(AuthorityServiceImpl authorityService) {
		this.authorityService = authorityService;
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

	// 관리페이지
	@RequestMapping("/management")
	public String management() {
		String url = "/superAdmin/management";

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

	// 권한요청승락
	/*@RequestMapping(value = "/authorityAccept", method = RequestMethod.POST)
	public String authorityAccept(HttpServletRequest request) {
		String url = "redirect:/superAdmin/authorityList";

		AlertVO alertVO = new AlertVO();
		String[] chkbox = request.getParameterValues("mem_id");
		for (int i = 0; i < chkbox.length; i++) {
			try {
				String authority = authorityService.authoritySelect1(chkbox[i]);// 아이디값의 권한을 가져옴 -> 그 권한을 변경
																	
				// 승락
				if (authority.equals("ROLE_USER")) {
					alertVO.setAl_id(chkbox[i]); //아이디값
					alertVO.setAl_authority("ROLE_ADMIN"); //변경된 권한 저장

					authorityService.alertY_insert(alertVO);
					authorityService.adminAuthority(chkbox[i]);
					

					} else if (authority.equals("ROLE_ADMIN")) {
					
					 * authorityService.userAuthority(chkbox[i]);//권한을 유저 변경하고,
					 * authorityService.authorityDelete(chkbox[i]);
					 * //authority테이블에서 삭제
					 
					alertVO.setAl_id(chkbox[i]);
					alertVO.setAl_authority("ROLE_USER");

					authorityService.alertY_insert(alertVO);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return url; // 승락을 누르면

	}*/

	
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
	
	@Inject
	WebApplicationContext context;
	

	@RequestMapping(value="reportGo",method = RequestMethod.POST , produces="application/json;charset=utf8")
	@ResponseBody
	public String reportEmail(@RequestBody Map<String,Object> reportMap ,HttpServletRequest request,Model model){
		
		String toEmail = null;
		VwMemPosSerVO vwMpsVO = null;
		String resultEmail = null;
		ArrayList<VwMemPosSerVO> ipList = null;
		ArrayList<CpuVO> cpuXls = null;
		
		String email = (String) reportMap.get("email");
		String ip = (String) reportMap.get("ip");
		
		Date date = new Date();
		SimpleDateFormat format = null;
		format = new SimpleDateFormat("yyMMddHHmm");
		System.out.println(format.format(date)+"@@@@@@@@@@@");
		
		
		JavaMailSender jmailSender = (JavaMailSender) mailSender;
		MimeMessage message = ((JavaMailSender) mailSender).createMimeMessage();
		
		String content = "<strong>안녕하세요.서버 관리자님</strong><br/>"
						+"<strong>주간 보고서 입니다.<br/>"
						+ "문의사항이 있으실 경우에는 Q & A 게시판을 이용하여 남겨주시면 신속하고 정확한 답변 해드리겠습니다.<br/><br/>"
						+ "항상 Observer를 이용해주셔서 감사합니다.</strong>";
		
		try {
			// Mail 전송
			vwMpsVO = reportService.adminMail(email);
			HSSFWorkbook book = reportService.CpuXls(ip);
			String name = format.format(date)+".xls";
//			System.out.println("$$$$$$$$$$$$$$$$$$$$$$"+name);
			// 경로설정
			ServletContextResource resource = new ServletContextResource(context.getServletContext(),"/WEB-INF/files/"+name);
			File newFile = resource.getFile();
			// 엑셀파일 만들기
			if(newFile.createNewFile()){
				book.write(newFile);
			}
			Thread.sleep(3000);
			
//			book.write(response.getOuptputStream());
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
}
