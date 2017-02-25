package com.ddit.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ddit.dto.MemberVO;
import com.ddit.dto.PositionListVO;
import com.ddit.dto.VWmemPosVO;
import com.ddit.dto.Vw_AuthorityVO;
import com.ddit.service.AlertServiceImpl;
import com.ddit.service.AuthorityServiceImpl;
import com.ddit.service.MemberServiceImpl;
import com.ddit.service.PositionListServiceImpl;
import com.ddit.service.SuperAdminServiceImpl;

@Controller
@RequestMapping("/superAdmin")
public class SuperAdminController {

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
	private SuperAdminServiceImpl superAdminService;
	
	public void setSuperAdminService(SuperAdminServiceImpl superAdminService) {
		this.superAdminService = superAdminService;
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
	
	@RequestMapping(value="/authorityMemberList", method = RequestMethod.GET)
	public String authorityListUpdate(HttpServletRequest request){
		
		String url = "superAdmin/memberList";
		
		/*String key = "";
		String tpage = request.getParameter("tpage");

		if (request.getParameter("key") != null) {
			key = request.getParameter("key");
		}

		if (tpage == null) {
			tpage = "1";
		} else if (tpage.equals("")) {
			tpage = "1";
		}
		
		request.setAttribute("key", key);
	    request.setAttribute("tpage",tpage);*/
		
		ArrayList<VWmemPosVO> memberList = null;
		
		try {
			memberList= superAdminService.VWmemPosMemberAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*String paging=null;
		try {
			memberList = memberDAO.listMember(Integer.parseInt(tpage),key);
			paging = memberDAO.pageNumber(Integer.parseInt(tpage), key);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/

		request.setAttribute("memberList", memberList);
		/*int n=memberList.size();   
	    request.setAttribute("memberListSize",n); 
	    request.setAttribute("paging", paging);   */
		
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
	

}
