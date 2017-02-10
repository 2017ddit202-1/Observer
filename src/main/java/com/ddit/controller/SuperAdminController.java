package com.ddit.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ddit.dto.AlertVO;
import com.ddit.dto.Vw_AuthorityVO;
import com.ddit.service.AuthorityServiceImpl;

@Controller
@RequestMapping("/superAdmin")
public class SuperAdminController {

	@Autowired
	private AuthorityServiceImpl authorityService;

	public void setAuthorityService(AuthorityServiceImpl authorityService) {
		this.authorityService = authorityService;
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
	@RequestMapping(value = "/authorityAccept", method = RequestMethod.POST)
	public String authorityAccept(HttpServletRequest request) {
		String url = "redirect:/superAdmin/authorityList";

		AlertVO alertVO = new AlertVO();
		String[] chkbox = request.getParameterValues("mem_id");
		for (int i = 0; i < chkbox.length; i++) {
			try {
				String authority = authorityService.authoritySelect1(chkbox[i]);// 아이디값의 권한을 가져옴 -> 그 권한을 변경
																	
				// 승락
				if (authority.equals("ROLE_USER")) {
					alertVO.setAl_id(chkbox[i]);
					alertVO.setAl_authority("ROLE_ADMIN");

					authorityService.alertY_insert(alertVO);

					/*
					 * authorityService.authorityDelete(chkbox[i]);
					 * //authority테이블에서 삭제
					 */} else if (authority.equals("ROLE_ADMIN")) {
					/*
					 * authorityService.userAuthority(chkbox[i]);//권한을 유저 변경하고,
					 * authorityService.authorityDelete(chkbox[i]);
					 * //authority테이블에서 삭제
					 */
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

	}

	// 체크후 수락을 누르면 권한요청승락으로 와 아이디 값을 받아 포지션 리스트의 권한을 변경해 주고
	// ATRT_USER_ACCEPT의 값을'y'로변경해준다.

}
