package com.ddit.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.sl.draw.binding.STTextShapeType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;


public class AutorityInterceptor extends HttpSessionHandshakeInterceptor{
	@Override
	public boolean beforeHandshake(ServerHttpRequest request,
			ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception { //로직수행

		// 위의 파라미터 중, attributes 에 값을 저장하면 웹소켓 핸들러 클래스의 WebSocketSession에 전달된다
		System.out.println("Before Handshake");
		
		ServletServerHttpRequest ssreq = (ServletServerHttpRequest) request;
		System.out.println("URI:" + request.getURI());

		HttpServletRequest req = ssreq.getServletRequest();
		

		
		

		// HttpSession 에 저장된 이용자의 아이디를 추출하는 경우
		if (req.getSession().getAttribute("loginUser") != null) {
			String loginUser =(String) req.getSession().getAttribute("loginUser");
			attributes.put("loginUser", loginUser);
			System.out.println("HttpSession에 저장된 id:" + loginUser + "!!!!!!!!!!!!!");
		}
		
		return super.beforeHandshake(request, response, wsHandler, attributes);

	}

	@Override
	public void afterHandshake(ServerHttpRequest request,
			ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception ex) { //beforeHandshake가 성공되면 -> afterHandshake 실행
		System.out.println("After Handshake");

		super.afterHandshake(request, response, wsHandler, ex);
	}
}
