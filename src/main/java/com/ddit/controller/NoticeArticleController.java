package com.ddit.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ddit.dto.Notice_ArticleVO;
import com.ddit.service.Notice_ArticleService;

@Controller
@RequestMapping("/article")
public class NoticeArticleController {
	@Autowired
	Notice_ArticleService articleService;

	// 공지사항 리스트
	@RequestMapping("/articleView")
	public String articleView(HttpServletRequest request,
			HttpServletResponse response, HttpSession session, Model model) {
		String url = "articleView";

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
		String id = (String) session.getAttribute("loginUser");

		ArrayList<Notice_ArticleVO> articleList = null;
		String paging = null;

		try {
			articleList = articleService.listArticlelist(
					Integer.parseInt(tpage), key);
			paging = articleService.totalPage(Integer.parseInt(tpage), key);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Notice_ArticleVO articleVO = null;

		/* 현재시각 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar c1 = Calendar.getInstance();
		String strToday = sdf.format(c1.getTime());
		int toDay = Integer.parseInt(strToday);
		// 20170222

		/* BD에 있는 date값 가져오기 */
		for (int i = 0; i < articleList.size(); i++) {
			articleVO = articleList.get(i);
			Date noar_date = articleVO.getNoar_date();
			int noar_seq = articleVO.getNoar_seq();

			DateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");

			String tempDate = sdFormat.format(noar_date);

			int date_new = Integer.parseInt(tempDate);

			if (date_new == toDay) { // new 아이콘 생성

				System.out
						.println("아이콘이 떠야 합니다!!!!!!!!!!!!!!!!!!!!!!!!진짜루!!!!!!!!!!");
				try {
					articleService.iconUpdate(noar_seq);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					articleService.iconUpdate_n(noar_seq);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		System.out.println("Today===============" + strToday);

		int n = articleList.size();

		model.addAttribute("articleList", articleList);
		model.addAttribute("qnaListSize", n);
		model.addAttribute("paging", paging);

		return url;

	}

	// 공지사항글쓰기
	@RequestMapping(value = "/articleWrite", method = RequestMethod.GET)
	public String articleWrite1(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = "articleWrite";
		return url;
	}

	// 공지사항글쓰기
	@RequestMapping(value = "/articleWrite", method = RequestMethod.POST)
	public String articleWrite(HttpServletRequest request,
			HttpServletResponse response, Model model) throws ServletException,
			IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String url = "redirect:articleView";
		HttpSession session = request.getSession();
		Notice_ArticleVO articleVO = new Notice_ArticleVO();
		articleVO.setNoar_id(request.getParameter("noar_id"));
		articleVO.setNoar_subject(request.getParameter("noar_subject"));
		articleVO.setNoar_content(request.getParameter("noar_content"));
		articleVO.setNoar_icon(1);
		ArrayList<Notice_ArticleVO> articleList = null;
		try {
			articleService.insertArticle(articleVO);
			articleList = articleService.listAllArticle();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		String id = (String) session.getAttribute("loginUser");

		String paging = null;

		try {
			articleList = articleService.listArticlelist(
					Integer.parseInt(tpage), key);
			paging = articleService.totalPage(Integer.parseInt(tpage), key);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int n = articleList.size();

		model.addAttribute("articleList", articleList);
		model.addAttribute("qnaListSize", n);
		model.addAttribute("paging", paging);

		return url;
	}

	// 공지사항 디테일
	@RequestMapping(value = "/detailArticle", method = RequestMethod.GET)
	public String detailArticle(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		String url = "detailArticle";

		String noar_seq = request.getParameter("noar_seq");
		int seq = Integer.parseInt(noar_seq);
		Notice_ArticleVO articleVO = null;
		try {
			articleVO = articleService
					.detailArticle(Integer.parseInt(noar_seq));
			articleService.articleCnt(seq);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* session.setAttribute("articleVO", articleVO); */
		request.setAttribute("articleVO", articleVO);

		return url;
	}

	// 공지글 삭제
	@RequestMapping("/articleDelete")
	public String articleDelete(HttpServletRequest request,
			HttpServletResponse response, HttpSession session, Model model) {
		String url = "articleView";

		String noar_seq = request.getParameter("noar_seq");

		Notice_ArticleVO articleVO = null;
		System.out.println(noar_seq);
		ArrayList<Notice_ArticleVO> articleList = null;
		try {
			articleService.deleteArticle(Integer.parseInt(noar_seq));
			articleList = articleService.listAllArticle();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("articleList", articleList);

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
		String id = (String) session.getAttribute("loginUser");

		String paging = null;

		try {
			articleList = articleService.listArticlelist(
					Integer.parseInt(tpage), key);
			paging = articleService.totalPage(Integer.parseInt(tpage), key);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int n = articleList.size();

		model.addAttribute("articleList", articleList);
		model.addAttribute("qnaListSize", n);
		model.addAttribute("paging", paging);
		return url;

	}

	// 공지사항 수정
	@RequestMapping(value = "/articleUpdate", method = RequestMethod.POST)
	public String articleUpdate(HttpServletRequest request,
			HttpServletResponse response, HttpSession session, Model model) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		String url = "articleView";

		Notice_ArticleVO articleVO = new Notice_ArticleVO();
		articleVO.setNoar_subject(request.getParameter("noar_subject"));
		articleVO.setNoar_content(request.getParameter("noar_content"));
		articleVO
				.setNoar_seq(Integer.parseInt(request.getParameter("noar_seq")));

		ArrayList<Notice_ArticleVO> articleList = null;
		try {
			articleService.updateArticle(articleVO);
			articleList = articleService.listAllArticle();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("articleList", articleList);

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
		String id = (String) session.getAttribute("loginUser");

		String paging = null;

		try {
			articleList = articleService.listArticlelist(
					Integer.parseInt(tpage), key);
			paging = articleService.totalPage(Integer.parseInt(tpage), key);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int n = articleList.size();

		model.addAttribute("articleList", articleList);
		model.addAttribute("qnaListSize", n);
		model.addAttribute("paging", paging);

		return url;
	}

	// 공지사항 서치
	@RequestMapping(value = "/articleSearch", method = RequestMethod.POST)
	public String articleSearch(
			@RequestParam(required = false) String keyField,
			@RequestParam String keyWord, Model model,
			HttpServletRequest request) {

		String url = "articleView";

		ArrayList<Notice_ArticleVO> articleList = null;

		int key = 0;

		if (keyField.equals("noar_seq")) {

			if (keyWord == "") {
				try {
					articleList = articleService.articleSearch_subject(keyWord);
					model.addAttribute("articleSearch", articleList);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (keyWord != null) {
				key = Integer.parseInt(keyWord);

				try {
					articleList = articleService.articleSearch_seq(key);
					model.addAttribute("articleSearch", articleList);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else if (keyField.equals("noar_subject")) {
			try {
				articleList = articleService.articleSearch_subject(keyWord);
				model.addAttribute("articleSearch", articleList);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			try {
				articleList = articleService.articleSearch_content(keyWord);
				model.addAttribute("articleSearch", articleList);
				model.addAttribute(keyField);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// ////////////페이징시작//////////////
		// key, keyField -> 키값을 넣어줘야함 근데 키값이 int, string

		// seq(int) keyword값이 존재한다면
		if (key != 0) {
			String tpage = request.getParameter("tpage");

			if (tpage == null) {
				tpage = "1";
			} else if (tpage.equals("")) {
				tpage = "1";
			}

			String paging = null;

			try {
				articleList = articleService.listArticlelist_seq(
						Integer.parseInt(tpage), key); // 1, 검색어
				paging = articleService.totalPage_seq(Integer.parseInt(tpage),
						key);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int n = articleList.size();

			model.addAttribute("articleList", articleList);
			model.addAttribute("qnaListSize", n);
			model.addAttribute("paging", paging);

		} else if (keyWord != null || keyField.equals("noar_subject")) {

			// String 키워드 값이 있으면
			String tpage = request.getParameter("tpage");

			if (tpage == null) {
				tpage = "1";
			} else if (tpage.equals("")) {
				tpage = "1";
			}

			String paging = null;

			try {
				articleList = articleService.listArticlelist_subject(
						Integer.parseInt(tpage), keyWord); // 1, 검색어
				paging = articleService.totalPage_subject(
						Integer.parseInt(tpage), keyWord);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int n = articleList.size();

			model.addAttribute("articleList", articleList);
			model.addAttribute("qnaListSize", n);
			model.addAttribute("paging", paging);
		}

		return url;
	}

}