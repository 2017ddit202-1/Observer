package com.ddit.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

public class WebHandshakeInterceptor 
		extends HttpSessionHandshakeInterceptor{

	@Override
	public boolean beforeHandshake(ServerHttpRequest request,
			ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
			System.out.println("()()()()()()()before()()()()()()");
			ServletServerHttpRequest ssreq = (ServletServerHttpRequest) request;
			System.out.println("URI : " + request.getURI());
			HttpServletRequest req = ssreq.getServletRequest();
			/*String userId = req.getParameter("userid");
	        System.out.println("param, id:"+userId);
	        attributes.put("userId", userId);*/
	        // HttpSession 에 저장된 이용자의 아이디를 추출하는 경우
			String id = (String)req.getSession().getAttribute("loginUser");
			System.out.println("httpsession - id : " + id);
			
			
	
		return super.beforeHandshake(request, response, wsHandler, attributes);
	}

	@Override
	public void afterHandshake(ServerHttpRequest request,
			ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception ex) {
		System.out.println("()()()()()()()after()()()()()()");
		super.afterHandshake(request, response, wsHandler, ex);
	}
	
}
