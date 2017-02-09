package com.ddit.handler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component

public class ObserverTest extends TextWebSocketHandler {

	int a = 1;

	private Map<String, WebSocketSession> users = new ConcurrentHashMap<String, WebSocketSession>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
		System.out.println("()()연결됨()()");
		users.put("아이디"+a, session);
		System.out.println(users.get("아이디"+a) + " = name 연결");
		a++;
		
	}

	
	/*
	 
	@Override
	protected void handleTextMessage(WebSocketSession session,
			TextMessage message) throws Exception {
		System.out.println("()()handleTextMessage()()");
		
		System.out.println(session.getId() + "의 content" + message.getPayload());
	}*/


	@Override
	public void handleMessage(WebSocketSession session,
			WebSocketMessage<?> message) throws Exception {
		System.out.println("handleMessage");
		int a = 1;
		System.out.println(users.get("아이디"+a));
	System.out.println(message.getPayload().toString());
	System.out.println("아이디"+a);
		
	/*for(WebSocketSession s : users.values()){
			s.sendMessage(message);
			System.out.println(s.getId()+message.getPayload());
		}
		*/
		
		
	}

/*	@Override
	protected void handleTextMessage(WebSocketSession session,
			TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		super.handleTextMessage(session, message);
	}
*/

	@Override
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus status) throws Exception {
		System.out.println("연결 종료");
		System.out.println( session.getId()+ "()()연결 종료()()");
		
		
	}


	
	
	
}
