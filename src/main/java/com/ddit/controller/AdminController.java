package com.ddit.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddit.dto.AdminVO;
import com.ddit.dto.Notice_ArticleVO;
import com.ddit.service.AdminServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminServiceImpl adminService;

	public void setAdminService(AdminServiceImpl adminService) {
		this.adminService = adminService;
	}

	// 전체리스트
	@RequestMapping("/adminQnaList")
	public String adminQnaLit(Model model, HttpServletRequest request) {
		
		String url = "admin/adminQnaList";
		
		
		// ///////////////페이징시작/////////////////////////
	      String key = "";
	      String tpage = request.getParameter("tpage");
	      if (request.getParameter("key") != null) {
	         key = request.getParameter("key");
	      }
	      if (tpage == null) {
	         tpage = "1";
	      } else if (tpage.equals("")) {
	         tpage = "1";
	      }

	      ArrayList<AdminVO> adminList = null;
	      String paging = null;

	      try {
	    	  adminList = adminService.listAdminlist(
	               Integer.parseInt(tpage), key);
	         paging = adminService.totalAdmin(Integer.parseInt(tpage), key);

	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }


	      int n = adminList.size();

	      model.addAttribute("adminList", adminList);
	      model.addAttribute("qnaListSize", n);
	      model.addAttribute("paging", paging);

	      return url;
		
		
		
		
		
	  
	/*	
		ArrayList<AdminVO> adminList = null;

		try {
			adminList = adminService.listAllAdmin();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("adminList", adminList);
		return url;*/

		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 어드민글쓰기
	@RequestMapping(value = "/adminWrite", method = RequestMethod.GET)
	public String adminInsert1() {
		String url = "admin/adminWrite";

		return url;

	}

	// 어드민글쓰기
	@RequestMapping(value = "/adminWrite", method = RequestMethod.POST)
	public String adminInsert2(HttpServletRequest request, Model model) {
		String url = "admin/adminQnaList";

		AdminVO adminVO = new AdminVO();
		adminVO.setAd_id(request.getParameter("ad_id"));
		adminVO.setAd_subject(request.getParameter("ad_subject"));
		adminVO.setAd_content(request.getParameter("ad_content"));

		ArrayList<AdminVO> adminList = null;

		try {
			adminService.insertAdmin(adminVO);
			adminList = adminService.listAllAdmin();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("adminList", adminList);

		return url;

	}

	// 디테일
	@RequestMapping(value = "detailAdmin", method = RequestMethod.GET)
	public String detailAdmin(HttpServletRequest request, Model model) {
		String url = "admin/detailAdmin";

		String seq = request.getParameter("admin_seq");
		int admin_seq = Integer.parseInt(seq);

		AdminVO adminVO = null;

		try {
			adminVO = adminService.select_Seq(admin_seq);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("adminVO", adminVO);

		return url;
	}

	@RequestMapping("/updateAdmin")
	public String updateAdmin(HttpServletRequest request, Model model) {
		String url = "admin/adminQnaList";


		AdminVO adminVO = new AdminVO();
		adminVO.setAdmin_seq(Integer.parseInt(request.getParameter("admin_seq")));
		adminVO.setAd_subject(request.getParameter("ad_subject"));
		adminVO.setAd_content(request.getParameter("ad_content"));

		System.out.println(adminVO + "^&&^ ^&&^ ^&&^");

		ArrayList<AdminVO> adminList = null;

		try {
			adminService.updateAdmin(adminVO);
			adminList = adminService.listAllAdmin();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("adminList", adminList);

		return url;
	}

	@RequestMapping("/deleteAdmin")
	public String deleteAdmin(HttpServletRequest request, Model model) {
		String url = "admin/adminQnaList";

		/*
		 * <delete id="deleteAdmin" parameterClass="int"> delete from admin
		 * where admin_seq=#admin_seq# </delete>
		 */

		int admin_seq = Integer.parseInt(request.getParameter("admin_seq"));

		ArrayList<AdminVO> adminList = null;

		try {
			adminService.deleteAdmin(admin_seq);
			adminList = adminService.listAllAdmin();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("adminList", adminList);

		return url;
	}

	@RequestMapping(value = "nswerAdmin", method = RequestMethod.POST, produces = "application/text;charset=utf8")
	@ResponseBody
	public String nswerAdmin(HttpSession session, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		String url = "";

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");

		/*
		 * content:$("textarea[name=email]").val(), seqNum:${param.qna_qseq} }),
		 */

		System.out.println(request.getParameter("content"));
		System.out.println(request.getParameter("seqNum"));

		String content = request.getParameter("content");
		String seqNum = request.getParameter("seqNum");

		AdminVO adminVO = new AdminVO();
		adminVO.setAdmin_seq(Integer.parseInt(seqNum));
		adminVO.setAd_nswer(content);

		try {
			adminService.nswerAdmin(adminVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return content;
	}

	@RequestMapping("/nswerN")
	public String nswerN(Model model) {
		String url = "admin/adminQnaList";

		ArrayList<AdminVO> adminList = null;

		try {
			adminList = adminService.nswerN();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("adminList", adminList);

		return url;
	}

	@RequestMapping("/nswerY")
	public String nswerY(Model model) {
		String url = "admin/adminQnaList";
		ArrayList<AdminVO> adminList = null;

		try {
			adminList = adminService.nswerY();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("adminList", adminList);
		return url;
		
	}
	
	//서치서치
	@RequestMapping(value="/adminSearch", method = RequestMethod.POST)
	public String adminSearch(HttpServletRequest request, Model model){
		String url="admin/adminQnaList";
		
		String keyField = request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		
		System.out.println(request.getParameter("keyField")+"^^^^^^^^^^^^^^^^^^^");
		System.out.println(request.getParameter("keyWord")+"^^^^^^^^^^^^^^^^^^^");
		
		
	
		ArrayList<AdminVO> adminList = null;
		
		
/*		if(keyField.equals("admin_seq")){
		int key = Integer.parseInt(keyWord);  
		
		try {
			adminList = adminService.Search_ad_seq(key);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}else if(keyField.equals("ad_id")){
			try {
				adminList = adminService.Search_ad_id(keyWord);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(keyField.equals("ad_subject")){
			try {
				adminList = adminService.Search_ad_subject(keyWord);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
		
		
		model.addAttribute("adminList", adminList);
		
		
		return url;
	}
	

}
