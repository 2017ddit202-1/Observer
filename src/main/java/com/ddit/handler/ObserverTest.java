package com.ddit.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


public class ObserverTest extends TextWebSocketHandler {

	private Logger logger = LoggerFactory.getLogger(ObserverTest.class);
	private List<WebSocketSession> connectsUsers;

	private Map<String, WebSocketSession> users = new ConcurrentHashMap<String, WebSocketSession>();

	// 나중에 map으로 구성하여 키 밸류를 이용해야함
	public ObserverTest() {
		connectsUsers = new ArrayList<WebSocketSession>();
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
		logger.info(session.getId() + "님 접속");
		System.out.println(session.getId()+"님 접속");
		logger.info("연결IP: " + session.getRemoteAddress().getHostName());
		connectsUsers.add(session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session,
			TextMessage message) throws Exception {
		logger.info(session.getId() + "님이 메시지 성공" + message.getPayload());
		System.out.println(session.getId()+"부리부리부리");
		for (WebSocketSession websocketSession : connectsUsers) {
			if (!session.getId().equals(websocketSession)) {
				websocketSession.sendMessage(new TextMessage(session
						.getRemoteAddress().getHostName()
						+ "->"
						+ message.getPayload()));
			}
		}

	}

	@Override
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus status) throws Exception {
		logger.info(session.getId() + "님 접속 종료");
		connectsUsers.remove(session);

	}

}
