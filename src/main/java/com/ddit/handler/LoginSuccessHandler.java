package com.ddit.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.ddit.dao.MemberDAO;
import com.ddit.dto.MemberVO;
import com.ddit.service.MemberServiceImpl;

public class LoginSuccessHandler extends
      SavedRequestAwareAuthenticationSuccessHandler {
   private static final Logger logger = LoggerFactory
         .getLogger(LoginSuccessHandler.class);
   
   @Autowired
	private MemberServiceImpl memberService;

	public void setMemberService(MemberServiceImpl memberService) {
		this.memberService = memberService;
	}
   
   @Override
   public void onAuthenticationSuccess(HttpServletRequest request,
         HttpServletResponse response, Authentication auth)
         throws ServletException, IOException {
      
      HttpSession session = request.getSession();
      session.setAttribute("loginUser", auth.getName());
      MemberVO mem = new MemberVO();
      
      String accept = request.getHeader("accept");
      String retUrl = request.getParameter("returl");
      
      try {
    	  mem = memberService.selectMember(auth.getName());
    	  session.setAttribute("loginUserVO", mem);
	} catch (SQLException e) {
		e.printStackTrace();
	}
      
      if(StringUtils.indexOf(accept, "html")>-1){
         if(retUrl==null||retUrl.isEmpty()){
            response.sendRedirect(request.getContextPath()+getDefaultTargetUrl());
            return;
         }
         response.sendRedirect(retUrl);
      
         
      } else if (StringUtils.indexOf(accept, "xml") > -1) {
    	  
         response.setContentType("application/xml;charset=utf-8");
         String data = StringUtils.join(new String[] {
               "<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "<response>",
               "<error>false</error>", 
               "<message>로그인하였습니다. </message>",
               "<returl>",retUrl,"</returl>",
               "</response>" });
         PrintWriter out = response.getWriter();
         out.print(data);
         out.flush();
         out.close();
      } else if (StringUtils.indexOf(accept, "json") > -1) {
         response.setContentType("application/json;charset=utf8");
         String data = StringUtils
               .join(new String[] { "{\"response\" : "
               		+ "{"," \"error\": false,",
                          " \"message\" : \"로그인하였습니다.\", ", 
                          " \"returl\" : \"",retUrl,"\"",
                          "} }" });
         PrintWriter out = response.getWriter();
         out.print(data);
         out.flush();
         out.close();
      }
   }

}