package com.ddit.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddit.dto.MemberVO;
import com.ddit.dto.QanswerVO;
import com.ddit.dto.QnaVO;
import com.ddit.dto.VWmemPosVO;
import com.ddit.service.MemberServiceImpl;
import com.ddit.service.QanswerService;
import com.ddit.service.QnaService;
import com.ddit.service.VWmemposService;

@Controller
@RequestMapping("/qna")
public class QnaController {
	@Autowired
	private QnaService qnaService;

	@Autowired
	private MemberServiceImpl memberService;

	@Autowired
	private QanswerService qanswerService;
	
	@Autowired
	private VWmemposService vWmemposService;


	@RequestMapping("/adminQnaList")
	public String adminQna(Model model,  HttpServletRequest request, HttpSession session){
		String url="qna/adminQnaList";
		
		String key = "";
		String tpage = request.getParameter("tpage");
		if (request.getParameter("key") != null) { 
			key = request.getParameter("key");
		}

		if (tpage == null) {
			tpage = "1"; // ���� ������ (default 1)
		} else if (tpage.equals("")) {
			tpage = "1";
		}

		String id = (String) session.getAttribute("loginUser");

		ArrayList<QnaVO> qnaList = null;
		String paging = null;
		VWmemPosVO mempos = null;
		//

		try {
			qnaList = qnaService.listqnalist(Integer.parseInt(tpage), key);
			paging = qnaService.totalPage(Integer.parseInt(tpage), key);
			mempos = vWmemposService.memposVO(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int n = qnaList.size(); //페이징을 위한

	///
		Date date = new Date();
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
		String time = (String)simpleDate.format(date);
		System.out.println(time);
		////
		
		
		model.addAttribute("mempos",mempos);
		model.addAttribute("time");
		model.addAttribute("qnaList", qnaList);
		model.addAttribute("qnaListSize", n);
		model.addAttribute("paging", paging);
		
		
		
		return url;
	}
	
	
	
	@RequestMapping("/qnaList")
	public String qnaList(/* @RequestParam("qseq") int qseq, */
	HttpSession session, Model model, HttpServletRequest request) {

		String url = "qna/qnaList";
		String key = "";
		String tpage = request.getParameter("tpage");
		if (request.getParameter("key") != null) { 
			key = request.getParameter("key");
		}

		if (tpage == null) {
			tpage = "1"; // ���� ������ (default 1)
		} else if (tpage.equals("")) {
			tpage = "1";
		}

		String id = (String) session.getAttribute("loginUser");

		ArrayList<QnaVO> qnaList = null;
		String paging = null;
		VWmemPosVO mempos = null;
		//

		try {
			qnaList = qnaService.listqnalist(Integer.parseInt(tpage), key);
			paging = qnaService.totalPage(Integer.parseInt(tpage), key);
			mempos = vWmemposService.memposVO(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int n = qnaList.size(); //페이징을 위한

	///
		Date date = new Date();
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
		String time = (String)simpleDate.format(date);
		System.out.println(time);
		////
		
		
		model.addAttribute("mempos",mempos);
		model.addAttribute("time");
		model.addAttribute("qnaList", qnaList);
		model.addAttribute("qnaListSize", n);
		model.addAttribute("paging", paging);
	
		return url;
	}

	// qna 글 쓰기
	@RequestMapping("/qnaWriteForm")
	public String qnaWriteForm(HttpSession session, Model model,
			HttpServletRequest request) {

		String url = "/qna/qnaWriteForm";
		String id = (String) session.getAttribute("loginUser");
		return url;
	}

	@RequestMapping("/qnaWrite")
	public String qnaWrite(HttpSession session, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		String url = "redirect:/qna/qnaList";
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		response.setCharacterEncoding("utf-8");
		QnaVO qnaVO = new QnaVO();
		qnaVO.setQna_subject(((String) request.getParameter("subject")));
		qnaVO.setQna_content(((String) request.getParameter("content")));
		qnaVO.setQna_id(((String) request.getParameter("id")));
		System.out.println(qnaVO.getQna_subject());
		System.out.println(qnaVO.getQna_content());

		try {
			qnaService.insertQna(qnaVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return url;
	}

	@RequestMapping("/detailQna")
	public String detailQna(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String url = "/qna/detailQna";
		MemberVO loginUserVO = null;
		QnaVO qnaVO = null;
		MemberVO qnaWriterVO = null;
		QanswerVO qansVO = null;

		String qseq = request.getParameter("qna_qseq");

		int qnaSeq = Integer.parseInt(qseq);

		try {
			loginUserVO = memberService.selectMember((String) session
					.getAttribute("loginUser"));
			qnaVO = qnaService.getQna(qnaSeq);
			qnaWriterVO = memberService.selectMember(qnaVO.getQna_id());
			qansVO = qanswerService.selectQanswer(qnaVO.getQseq());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// //

		// 답변을 나타내기 위한 정보
		model.addAttribute("qansVO", qansVO);

		// 로그인한 유저 계정 정보
		model.addAttribute("loginUserVO", loginUserVO);

		// 게시글번호에 해당되는 qna정보
		model.addAttribute("qnaVO", qnaVO);

		// qna작성자의 계정 정보
		model.addAttribute("qnaWriterVO", qnaWriterVO);

		return url;
	}

	
	/* @RequestMapping(value="/qnaList", method=RequestMethod.GET) */
	/* @RequestParam(value="qna_qseq")String qseq, */
	/* @RequestParam(value="qna_qseq", defaultValue="1")int qna_qseq */
	@RequestMapping(value = "/qAnswer", method = RequestMethod.POST, produces = "application/text;charset=utf8")
	@ResponseBody
	public String qAnswer(HttpSession session, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");

		String content = request.getParameter("content");
		String seqNum = request.getParameter("seqNum");

		String loginUser = (String) session.getAttribute("loginUser");

		// 게시글번호 유지 해야됨
		QanswerVO qanswerVO = new QanswerVO();
		QanswerVO qanswerVO2 = null;

		QnaVO qnaVO = new QnaVO();
		qanswerVO.setQans_id(loginUser);
		qanswerVO.setQans_content(content);
		qanswerVO.setQans_qseq(Integer.parseInt(seqNum));

		try {
			qanswerService.insertQanswer(qanswerVO);

			qnaVO = qnaService.getQna(Integer.parseInt(seqNum));
			qnaVO.setQna_check(1);
			qnaService.updateQnaCheck(qnaVO);
			qanswerVO2 = qanswerService.selectQanswer(Integer.parseInt(seqNum));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(loginUser);
		System.out.println(content);
		model.addAttribute("qansVO", qanswerVO2);
		URLEncoder.encode(content);

		return content;
	}

	// ////////////////////////

	@RequestMapping("/qnaUpdate")
	public String qnaUpdate(Model model, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {
		String url = "qna/qnaUpdate";
		System.out.println("글수정을 위한 컨트롤러");

		QnaVO qnaVO = new QnaVO();
		int qseq = Integer.parseInt(request.getParameter("qna_seq"));
		String userid = (String) session.getAttribute("loginUser");

		try {
			qnaVO = (QnaVO) qnaService.selectQna(qseq, userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("qnaVO", qnaVO);

		return url;
	}

	@RequestMapping("/qnaModify")
	public String qnaModify(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, Model model) {

		String url = "redirect:/qna/qnaList";
		QnaVO qnaVO = new QnaVO();
		
		int qseq = Integer.parseInt(request.getParameter("qna_seq"));
		String userid = (String) session.getAttribute("loginUser");
		try {
			qnaVO = qnaService.selectQna(qseq, userid);
			qnaVO.setQna_subject(request.getParameter("qna_subject"));
			qnaVO.setQna_content(request.getParameter("qna_content"));
			qnaService.updateQnaVO(qnaVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}
	
	@RequestMapping("/qnaDelete")
	public String qnaDelete(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		String url = "redirect:/qna/qnaList";
		System.out.println(request.getParameter("qna_seq"));
		int qseq = Integer.parseInt(request.getParameter("qna_seq"));
		int result = 0;
		ArrayList<QnaVO> qnaList = null;
		try {
			
			
			result = qnaService.deleteQna(qseq);
			qnaList = qnaService.listAllQna();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("qnaList", qnaList);

		return url;
	}

	
	
	// //////

}